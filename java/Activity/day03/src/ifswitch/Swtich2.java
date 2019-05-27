package ifswitch;

import java.util.Scanner;

public class Swtich2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int ld = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			ld = 31;
			break;
		case 2:
			ld = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			ld = 30;
			break;
		}
		System.out.println(ld);
	}
}
