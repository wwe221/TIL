package baekzoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Virus {
	int x, y;

	public Virus(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class N17141 {
	static int n, m;
	static int[][] map;
	static int[][] tmap;
	static ArrayList<Virus> list = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		tmap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = sc.nextInt();
				if (a == 2) {
					list.add(new Virus(i, j));
					map[i][j] = 0;
				} else
					map[i][j] = a;
			}
		}
		dfs(0, 0, map);
		if(min==Integer.MAX_VALUE)
			min=-1;
		System.out.println(min);

	}

	static void dfs(int cnt, int ind, int[][] map) {
		if (ind > list.size()) {
			return;
		}
		if (cnt >= m) {
			copyMap();
			int time = 0;
			int tmp = 0;
			int tmp2 = 0;
			while (true) {
				tmp = infect(tmap);
				if (tmp == tmp2)
					break;
				tmp2 = tmp;
				time++;
			}
			if(!check(tmap)) {
				min = Math.min(min, time);
			}
			return;
		}
		for (int i = ind; i < list.size(); i++) {
			Virus v = list.get(i);
			map[v.x][v.y] = 2;
			dfs(cnt + 1, i + 1, map);
			map[v.x][v.y] = 0;
		}
	}

	static boolean check(int[][] map) {
		boolean re =false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==0)
					re = true;
			}
		}
		return re;
	}

	static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmap[i][j] = map[i][j];
			}
		}
	}

	static int infect(int[][] map) {

		Queue<Virus> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 2) {
					q.add(new Virus(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Virus v = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = 2;
					}
				}
			}
		}
		return count(map);

	}

	static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 2)
					cnt++;
			}
		}
		return cnt;
	}

	static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
