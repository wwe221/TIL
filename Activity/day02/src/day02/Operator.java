package day02;

public class Operator {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		int re = ++a + b++;
		System.out.printf("%d,%d,%d\n", a, b, re);
		if (a++ < 20 || b++ < 20)
			System.out.println(a + " " + b);

		double i1 = 0.0;
		double i2 = 0.0;
		double i3 = i1 / i2;
		System.out.println(i3);
	}
}
