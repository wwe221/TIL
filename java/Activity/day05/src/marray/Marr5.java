package marray;

import java.util.Random;
import java.util.Scanner;

public class Marr5 {

	public static void main(String[] args) {
		int[] ma[] = new int[5][5];
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[0].length; j++) {
				ma[i][j] = ran.nextInt(100) + 1;
			}
		}
		int a = sc.nextInt();
		Loop1: for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.print(ma[i][j] + " ");				
				if (ma[i][j] == a)
					break Loop1;
			}
			System.out.println();
		}

	}

}
