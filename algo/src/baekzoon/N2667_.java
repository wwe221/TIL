package baekzoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class N2667_ {
	static int[][] map;
	static int l;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		map = new int[l][l];
		for (int i = 0; i < l; i++) {
			String a = sc.next();
			for (int j = 0; j < l; j++) {
				map[i][j] = a.charAt(j) - '0';
			}
		}
		int total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (map[i][j] == 1) {
					cnt = 0;
					total++;
					dfs(i, j);
					pq.add(cnt);					
				}
			}
		}
		System.out.println(total);
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}

	static void dfs(int x, int y) {
		map[x][y] = 0;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
				if (map[nx][ny] == 1)
					dfs(nx, ny);
			}
		}
	}
}
