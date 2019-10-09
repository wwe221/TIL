package baekzoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1012
public class N1012 {
	static int[][] map;
	static int n;
	static int m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int xx = sc.nextInt();
		for (int mmm = 0; mmm < xx; mmm++) {
			n = sc.nextInt();
			m = sc.nextInt();
			int l = sc.nextInt();
			map = new int[n][m];
			for (int i = 0; i < l; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void dfs(int x, int y) {
		map[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (map[nx][ny] == 1)
					dfs(nx, ny);
			}
		}

	}

}
