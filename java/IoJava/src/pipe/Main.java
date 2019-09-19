package pipe;

public class Main {

	public static void main(String[] args) {
		InputThread it = new InputThread("");
		OuputThread ot = new OuputThread("");
		it.connect(ot.getOutput());
		it.start();
		ot.start();
	}

}
