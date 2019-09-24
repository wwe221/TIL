package com.example.wschatt;

import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket socket;
	InputStream in;
	DataInputStream din;
	OutputStream out;
	DataOutputStream dout;
	boolean rflag = true;

	public Client() {
	}

	public Client(String ip, int port) throws IOException {
		boolean flag = true;
		while (flag) {
			try {
				Log.i("test",ip+port);
				socket = new Socket(ip, port);

				if (socket != null && socket.isConnected())
					flag = false;
			} catch (Exception e) {
				System.out.println("Re-Try Connection");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		new ReCThread(socket).start();
	}

	public void sendMsg(String msg) throws IOException {
		SendThread s = new SendThread(socket);
		s.setMsg(msg);
		s.start();
	}

	public void start() throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			boolean inflag = true;
			System.out.println("Input Msg");
			while (inflag) {
				String instr = sc.next();
				sendMsg(instr);
				if (instr.equals("q")) {
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {			
			sc.close();
		}
	}

	class SendThread extends Thread {
		Socket socket;
		OutputStream out;
		DataOutputStream dout;
		String msg;

		public SendThread(Socket socket) throws IOException {
			this.socket = socket;
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void run() {
			try {
				if (dout != null) {
					dout.writeUTF(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ReCThread extends Thread {
		Socket socket;
		InputStream in;
		DataInputStream din;

		public ReCThread() {
		}

		public ReCThread(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			din = new DataInputStream(in);
		}

		public void run() {
			while (rflag) {
				try {
					String str = din.readUTF();
					System.out.println(str);
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			Client c = new Client("70.12.60.110", 8888);
			c.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
