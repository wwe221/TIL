package ws2;

//캔디 크러시
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game2 {
	static char[][] map = new char[12][12];
	static int score = 0;
	static Random ran = new Random();
	static Scanner sc = new Scanner(System.in);
	static char[] s = { 'A', 'B', 'C', 'D', 'E' };
	static boolean flag = false;

	public static void main(String[] args) {
		int r;
		int ii = 0, jj = 0, nn = 0, mm = 0;
		int a = 0;
		char cng;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				make(i, j);
			}
		}
		check();
		check();
		print();
		score = 0;
		flag = true;
		while (true) {
			System.out.println("좌표를 입력하세요.");
			ii = sc.nextInt();
			jj = sc.nextInt();
			System.out.println("무엇과 바꾸시겠습니까?\n1:위 2:아래 3:좌 4:우.");
			a = sc.nextInt(); // 1:위 2:아래 3:좌 4:우
			switch (a) {
			case 1:// 위
				if (ii < 1) {
					System.out.println("벽과 바꿀수 없습니다.");
					break;
				}
				nn = ii - 1;
				mm = jj;
				cng = map[ii][jj];
				map[ii][jj] = map[nn][jj];
				map[nn][jj] = cng;
				break;
			case 2:// 아래
				if (ii > 8) {
					System.out.println("벽과 바꿀수 없습니다.");
					break;
				}
				nn = ii + 1;
				mm = jj;
				cng = map[ii][jj];
				map[ii][jj] = map[nn][jj];
				map[nn][jj] = cng;
				break;
			case 3:// 좌
				if (jj < 1) {
					System.out.println("벽과 바꿀수 없습니다.");
					break;
				}
				nn = ii;
				mm = jj - 1;
				cng = map[ii][jj];
				map[ii][jj] = map[ii][mm];
				map[ii][mm] = cng;
				break;
			case 4:// 우
				if (jj > 8) {
					System.out.println("벽과 바꿀수 없습니다.");
					break;
				}
				nn = ii;
				mm = jj + 1;
				cng = map[ii][jj];
				map[ii][jj] = map[ii][mm];
				map[ii][mm] = cng;
				break;
			}
			earn(ii, jj);
			earn(nn, mm);
			check();
			print();
		}

	}

	static void print() {
		System.out.print("  ");
		for (int i = 0; i < map.length - 3; i++) {
			System.out.print(i + " ");
		}
		System.out.println(" Sccore : " + score);
		for (int i = 0; i < map.length - 3; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void make(int i, int j) {
		if (i >= 9 || j >= 9)
			return;
		int r = (ran.nextInt(5) + 1) % 5;
		map[i][j] = s[r];
		if (j >= 2) {
			if (map[i][j] == map[i][j - 1] && map[i][j] == map[i][j - 2]) {
				make(i, j);
			}
		}
		if (i >= 2) {
			if (map[i][j] == map[i + 1][j] && map[i][j] == map[i + 2][j]) {
				make(i, j);
			}
		}
	}

	static void earn(int i, int j) {
		if (map[i][j] == map[i][j + 1] && map[i][j] == map[i][j + 2]) {
			score++;
			System.out.println("Crush!");
			make(i, j);
			make(i, j + 1);
			make(i, j + 2);
		}
		if (j >= 1 && map[i][j] == map[i][j + 1] && map[i][j] == map[i][j - 1]) {
			score++;
			System.out.println("Crush!");
			make(i, j);
			make(i, j + 1);
			make(i, j - 1);
		}
		if (j >= 2 && map[i][j] == map[i][j - 1] && map[i][j] == map[i][j - 2]) {
			score++;
			System.out.println("Crush!");
			make(i, j);
			make(i, j - 1);
			make(i, j - 2);
		}
		if (map[i][j] == map[i + 1][j] && map[i + 1][j] == map[i + 2][j]) {
			score++;
			System.out.println("Crush!");
			make(i, j);
			make(i + 1, j);
			make(i + 2, j);
		}
		if (i >= 1 && map[i][j] == map[i + 1][j] && map[i + 1][j] == map[i - 1][j]) {
			score++;
			System.out.println("Crush!");
			make(i, j);
			make(i + 1, j);
			make(i - 1, j);
		}
		if (i >= 2 && map[i][j] == map[i - 2][j] && map[i - 2][j] == map[i - 1][j]) {
			score++;
			System.out.println("Crush!");
			make(i, j);
			make(i - 2, j);
			make(i - 1, j);
		}
	}

	static void check() {
		for (int i = 0; i < map.length - 2; i++) {
			for (int j = 0; j < map.length - 2; j++) {
				if (map[i][j] == map[i][j + 1] && map[i][j] == map[i][j + 2]) {
					make(i, j);
					make(i, j + 1);
					make(i, j + 2);
				}
				if (map[j][i] == map[j + 1][i] && map[j + 1][i] == map[j + 2][i]) {
					make(j, i);
					make(j + 1, i);
					make(j + 2, i);

				}

			}
		}

	}

}