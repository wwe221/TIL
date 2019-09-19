package pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class InputThread extends Thread {
	PipedReader input = new PipedReader();
	BufferedReader br;
	public InputThread(String name) {
		super(name);
		input = new PipedReader();
	}

	public void run() {
		StringWriter sw = new StringWriter();
		br = new BufferedReader(input);
		StringBuffer sb = new StringBuffer();
		int data;
		String str;
		System.out.println("Ready");
		try {
			while ((str=br.readLine())!=null) { // input 이 있기 까지 기다린다.
				sb.append(str);
			}
			System.out.println("recived " + sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PipedReader getInput() {
		return input;
	}

	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
