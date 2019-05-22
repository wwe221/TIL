package day02;

import java.util.Scanner;

public class Scann {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int i = Integer.parseInt(str);
		System.out.println(str);
		scan.close();
	}
}
