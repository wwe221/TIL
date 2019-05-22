package ws1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//숫자야구
public class Game {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int goal[] = new int[4];
		int u[] = new int[4];
		int r;
		boolean[] numb = new boolean[10];
		int strike =0;
		int ball =0;
		int out =0;
		boolean flag;
		for (int i = 0; i < goal.length; i++) {
			r = ran.nextInt(10);
			if (numb[r] == false) {
				goal[i] = r;
				numb[goal[i]] = true;
			} else
				i--;
		}
		//System.out.println(Arrays.toString(goal));		
		while (strike!=4) {
			for (int i = 0; i < goal.length; i++) {
				u[i] = sc.nextInt();
			}
			strike = 0;
			ball = 0;
			out = 0;
			int j;
			for (int i = 0; i < goal.length; i++) {
				flag = false;
				for (j = 0; j < goal.length; j++) {
					if (u[i] == goal[j]) {
						if (i == j) {
							flag = true;
							strike++;
							break;
						}
						else {
							flag = true;
							ball++;
							break;
						}
					}
				}
				if (!flag && j == goal.length)
					out++;
			}
			System.out.printf("%dS %dB %dO\n", strike, ball, out);
		}//end while
		System.out.printf("홈런입니다");
	}

}
