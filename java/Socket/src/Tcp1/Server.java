package Tcp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class tThread extends Thread {
	ServerSocket serverSocket;
	Socket socket;
	OutputStream out;
	OutputStreamWriter outW;
	BufferedWriter bw;
	int cnt;
	public tThread(Socket socket, int cnt) {
		this.socket = socket;
		this.cnt = cnt;
	}
	public void run() {
		try {
			System.out.println("Server Accepted.." + cnt + ": " + socket.getInetAddress());
			Thread.sleep(2000);
			out = socket.getOutputStream();
			outW = new OutputStreamWriter(out);
			bw = new BufferedWriter(outW);
			bw.write("welcome to the paradise" + cnt);
			if (bw != null)
				bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (socket != null)
				socket.close();
			if (bw != null)
				bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Thread "+cnt+" ends");
	}
}
public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	OutputStream out;
	OutputStreamWriter outW;
	BufferedWriter bw;
	InputStream in;
	InputStreamReader inR;
	BufferedReader br;
	int cnt = 0;

	public Server(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	public void startServer() throws IOException {
		System.out.println("Server Start..");

		boolean flag = true;
		while (flag) {
			System.out.println("Server Ready..");
			socket = serverSocket.accept();
			cnt++;
			tThread t = new tThread(socket, cnt);
			t.start();
		}
		if (br != null)
			br.close();
		if (socket != null)
			socket.close();
		System.out.println("Server Dead... ...");
	}

	public static void main(String[] args) {
		try {
			Server s = new Server(8888);
			s.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
