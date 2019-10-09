package baekzoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/14502
//어렵다... 나중에 이거보고 공부하자  https://bcp0109.tistory.com/25 
public class N14502 {
	static class Dot {
		int x, y;
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;
	static int[][] tmap;
	static int[][] infect;
	static int x;
	static int y;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		map = new int[x][y];
		tmap = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		infect = map;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (map[i][j] == 0) {
					copyMap();
					tmap[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(infect[i][j]);
			}
			System.out.println();
		}
	}

	static void dfs(int cnt) {
		if (cnt == 3) {
			infect = tmap;
			return;
		}

	}

	static void copyMap() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				tmap[i][j] = map[i][j];
			}
		}
	}

	static void infection(int a, int b) {
		for (int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
				if (infect[nx][ny] == 0) {
					infect[nx][ny] = 2;
					infection(nx, ny);
				}
			}
		}

	}

}
