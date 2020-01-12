package baekzoon;

import java.util.Scanner;

public class N14502_2 {
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
	static int n;
	static int m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		tmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0, 0, map);
		System.out.println(max);

	}

	static void dfs(int x, int y, int cnt, int[][] map) {
		if (cnt >= 3) {
			copyMap();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (tmap[i][j] == 2) {
						infect(i, j, tmap);
					}
				}
			}
			count(tmap);
			return;
		}
		for (int nx = 0; nx < n; nx++) {
			for (int ny = 0; ny < m; ny++) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = 1;
					dfs(nx, ny, cnt + 1, map);
					map[nx][ny] = 0;
				}

			}
		}
	}

	static void infect(int x, int y, int[][] map) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = 2;
					infect(nx, ny, map);
				}
			}
		}
	}

	static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmap[i][j] = map[i][j];
			}
		}
	}

	static void count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
