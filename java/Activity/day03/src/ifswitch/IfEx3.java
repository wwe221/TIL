package ifswitch;

import java.util.Scanner;

public class IfEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		int min = 0, max = 0;
		if (a > b && a > c) {
			max = a;
		} else if (b > a && b > c)
			max = b;
		else
			max = c;
		if (a < b && a < c) {
			min = a;
		} else if (b < a && b < c)
			min = b;
		else
			min = c;
		int min2 = a < b ? (a < c) ? a : c : (b < c) ? b : c;
		int max2 = a > b ? (a > c) ? a : c : (b > c) ? b : c;
		int min3 = Math.min(c, (Math.min(a, b)));
		System.out.printf("Min:%d\tMax: %d\n\t%d\t%d", min, max, min2, max2);
	}

}
