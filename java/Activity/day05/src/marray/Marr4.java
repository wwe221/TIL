package marray;

import java.util.Arrays;

public class Marr4 {
	public static void main(String[] args) {
		String sa[][] = new String[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				sa[i][j] = i + "" + j;
			}
		}
		for (String i[] : sa) {
			for (String data : i)
				System.out.printf("%s ", data);
		}

	}

}
