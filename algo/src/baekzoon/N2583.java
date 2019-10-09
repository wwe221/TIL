package baekzoon;

import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2583
public class N2583 {
	static int[][] map;
	static int n;
	static int m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int l = sc.nextInt();
		for (int i = 0; i < l; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for (int k = b; k < d; k++) {
				for (int j = a; j < c; j++) {
					map[k][j] = 1;
				}
			}
		}

		int total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					cnt = 0;
					total++;
					dfs(i, j);
					pq.add(cnt);
				}
			}
		}
		System.out.println(total);
		while(!pq.isEmpty())
			System.out.print(pq.poll()+" ");
		
	}

	static void dfs(int x, int y) {
		map[x][y] = 1;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (map[nx][ny] == 0) {
					dfs(nx, ny);
				}

			}
		}
	}
}
