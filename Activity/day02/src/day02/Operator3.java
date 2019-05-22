package day02;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = str.charAt(0);
		if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
			System.out.println("문자네");
			sc.close();
			return;
		} else if (c >= '0' && c <= '9') {
			System.out.println("숫자네");
		}
		System.out.println(++c);
		sc.close();
	}

}
