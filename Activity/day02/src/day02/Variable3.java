package day02;

import java.util.Scanner;

public class Variable3 {
	public static void main(String[] args) {
		// 4과목 점수를 정수로 입력 받는다,
		// 합계와 평균 구하라
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, sum;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		double avg;
		sum = a + b + c + d;
		avg = (double) sum / 4;
		System.out.println(sum + "\t" + avg);
		sc.close();

	}

}
