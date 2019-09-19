package pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class OuputThread extends Thread {
	PipedWriter output = new PipedWriter();

	public OuputThread(String name) {
		super(name);
		output = new PipedWriter();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			String msg = sc.next();
			System.out.println(msg);
			output.write(msg);
			output.flush();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PipedWriter getOutput() {
		return output;
	}

	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
