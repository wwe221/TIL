package ifswitch;

public class IfEx2 {

	public static void main(String[] args) {
		int a = 87;
		char c = 'F';
		if (a >= 90) {
			c = 'A';
		} else if (a >= 80) {
			c = 'B';
		} else if (a >= 70) {
			c = 'C';
		} else
			c = 'D';
		System.out.println(c);
	}

}
