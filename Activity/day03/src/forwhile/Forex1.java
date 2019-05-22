package forwhile;

public class Forex1 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		System.out.println();
		for (int i = 10; i >= 0; i--) {
			System.out.print(i);
		}
		System.out.println();
		for (int i = 1; i < 10; i += 2) {
			System.out.print(i);
		}
		System.out.println();
		int i, j;
		for (i = 1, j = 1; i + j < 10; i++, j++) {
		}
		System.out.print(i + j);
		System.out.println();
		int sum;
		for (sum = 0, i = 1, j = 10; i <= 10; i++, j--) {
			System.out.println(i + " " + j);
			if (i * j % 5 == 0)
				sum += i + j;
		}
		System.out.println("sum = " + sum);

	}
}
