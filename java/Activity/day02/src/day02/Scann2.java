package day02;

import java.util.Scanner;

public class Scann2 {

	public static void main(String[] args) {
		// 2개 숫자 받아들여 a/b 계산, 출력시 소숫점 3자리까지
		Scanner sc = new Scanner(System.in);
//		double a, b;
//		System.out.print("Number1 :");
//		a = sc.nextDouble();
//		System.out.print("Number2 :");
//		b = sc.nextDouble();
//		System.out.printf("result = %10.3f", (a / b));
		String ohora;
//		ohora = sc.nextLine();
//		int i = Integer.parseInt(ohora);
//		ohora = sc.nextLine();
//		int j = Integer.parseInt(ohora);		
//		System.out.printf("result = %1.3f\n", (double) i / (double) j);
		int a = 0b1010;
		int b = 0b1111;
		System.out.printf("%d",b-a);			
		sc.close();
		
	}
}
