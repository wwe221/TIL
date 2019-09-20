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

public class Client {
	String ip;
	int port;
	ServerSocket serverSocket;
	Socket socket;
	InputStream in;
	InputStreamReader inR;
	BufferedReader br;
	OutputStream out;
	OutputStreamWriter outW;
	BufferedWriter bw;
	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void request() throws Exception {
		try {				
			in = socket.getInputStream();
			inR = new InputStreamReader(in);
			br = new BufferedReader(inR);
			String str = br.readLine();
			System.out.println(str);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			if (in != null)
				in.close();
			if (inR != null)
				inR.close();
			if (br != null)
				br.close();
			if (bw != null)
				br.close();
		}
	}
	public void startClient() throws Exception {
		System.out.println("Client Start");
		try {
			socket = new Socket(ip, port);
			System.out.println(socket.getInetAddress());
			request();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				socket.close();
		}
	}
	public static void main(String[] args) {
		Client c = new Client("70.12.60.100", 8888);
		try {
			c.startClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}