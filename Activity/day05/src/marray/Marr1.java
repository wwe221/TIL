package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr1 {

	public static void main(String[] args) {
		int a[] = new int[5];
		int[] ma2[][] = new int[5][4][5];
		int[] ma[] = new int[3][4];
		Random ran = new Random();

		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[0].length; j++) {
				ma[i][j] = ran.nextInt(10);
				ma2[i][i][j] = ran.nextInt(10);

			}
		}
		for (int i[] : ma) {
			for (int j : i)
				System.out.print(j);
			System.out.println();

		}
		for (int i[][] : ma2)
			System.out.println(i[0][0]);

	}

}
