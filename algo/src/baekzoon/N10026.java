package baekzoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10026
public class N10026 {
	static int l;
	static int map[][];
	static int smap[][];
	static int visit[][];
	static int svisit[][];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cnt = 0, cnt2 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		map = new int[l][l];
		smap = new int[l][l];
		visit = new int[l][l];
		svisit = new int[l][l];
		for (int i = 0; i < l; i++) {
			String in = sc.next();
			for (int j = 0; j < l; j++) {
				char a = in.charAt(j);
				int b = 0;
				if (a == 'R') {
					b = 1;
				} else if (a == 'G') {
					b = 2;
				} else if (a == 'B') {
					b = 3;
				}
				map[i][j] = b;
				if (b == 2)
					b = 1;
				smap[i][j] = b;
			}
		}
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (visit[i][j] == 0) {
					if (map[i][j] == 1) {
						dfs(i, j, map, visit,1);						
						cnt++;
					} else if (map[i][j] == 2) {
						dfs(i, j, map, visit,2);
						cnt++;
					} else if (map[i][j] == 3) {
						dfs(i, j, map, visit,3);
						cnt++;
					}
				}
				if (svisit[i][j] == 0) {
					if (smap[i][j] == 1) {
						dfs(i, j, smap, svisit,1);						
						cnt2++;
					} else if (smap[i][j] == 3) {
						dfs(i, j, smap, svisit,3);
						cnt2++;
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(cnt2);
	}

	static void dfs(int x, int y, int[][] target,int [][]visit,int t) {
		visit[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
				if (target[nx][ny] == target[x][y] && target[nx][ny] == t && visit[nx][ny] == 0) {
					visit[nx][ny] = 1;
					dfs(nx, ny, target,visit, t);
				}
			}
		}
	}

}
