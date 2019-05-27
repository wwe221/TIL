package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("빙고판 사이즈를 입력하세요");
		int a = 0;
		while (true) {
			a = sc.nextInt();
			if (a > 10 || a < 1) {
				System.out.println("\n1부터 10까지의 값만 입력하세요");
			} else
				break;
		}
		System.out.println("몇점 내기를 하시겠습니까");
		int goal;
		while (true) {
			goal = sc.nextInt();
			if (goal > (2 * a + 2) || a <= 0) {
				System.out.printf("점수가 범위를 벗어났습니다. 1 ~ %d까지 입력하세요.\n", (2 * a + 2));
			} else
				break;
		}
		int score = 0;
		boolean[] check = new boolean[101];
		int[][] pan = new int[a][a];
		int[][] pan2 = new int[a][a];
		int r;
		int sumG[] = new int[a];
		int sumS[] = new int[a];
		int flagG[] = new int[a];
		int flagS[] = new int[a];
		int sum, sum2, sum3, sum4;
		int c;
		int f1 = 0, f2 = 0, f3 = 0, f4 = 0;
		System.out.println("1: 자동 번호  2: 직접 입력");
		int o = sc.nextInt();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				while (true) {
					r = ran.nextInt(100) + 1;
					if (check[r] == false) {
						check[r] = true;
						pan2[i][j] = r;
						break;
					} else if (check[r] == true) {
						continue;
					}
				}
			}
		}
		switch (o) {
		case 1:
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					while (true) {
						r = ran.nextInt(100) + 1;
						if (check[r] == false) {
							check[r] = true;
							pan[i][j] = r;
							break;
						} else if (check[r] == true) {

							continue;
						}
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					while (true) {
						r = sc.nextInt();
						if (check[r] == false) {
							check[r] = true;
							pan[i][j] = r;
							break;
						} else if (check[r] == true) {
							System.out.println("중복된 숫자가 있어요.");
							continue;
						}
					}
				}
				System.out.println(Arrays.toString(pan[i]));
			}
			break;
		}
		while (true) {			
			System.out.println("####################################\n");
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print(pan2[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
			
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print(pan[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println(" 번호를 입력하세요.");
			r = sc.nextInt();
			c = 0;
			loop: for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					if (pan[i][j] == r) {
						pan[i][j] = 0;
						c = 1;
						break loop;
					}
				}
			}
			if (c == 0)
				System.out.println("판에 없는 숫자 입니다.");
			sum3 = 0;
			for (int i = 0, j = 0; i < a; i++, j++) {
				sum3 += pan[i][j];
			}
			sum4 = 0;
			for (int i = 0, j = a - 1; i < a; i++, j--) {
				sum4 += pan[i][j];
			}

			for (int i = 0; i < a; i++) {
				sum = 0;
				sum2 = 0;
				for (int j = 0; j < a; j++) {
					sum += pan[i][j];
					sum2 += pan[j][i];
				}
				sumG[i] = sum;
				sumS[i] = sum2;
				if (sumG[i] == 0 && flagG[i] == 0) {
					System.out.println(++score + " 빙고@@");
					flagG[i] = 1;
				}
				if (sumS[i] == 0 && flagS[i] == 0) {
					System.out.println(++score + " 빙고@@");
					flagS[i] = 1;
				}
				if (sum3 == 0 && f3 == 0) {
					System.out.println(++score + " 빙고@@");
					f3 = 1;
				}
				if (sum4 == 0 && f4 == 0) {
					System.out.println(++score + " 빙고@@");
					f4 = 1;
				}
			} // end for
			if (score >= goal) {
				System.out.println("!!!이겼다!!!");
				break;
			}
		} // end while

	}

}
