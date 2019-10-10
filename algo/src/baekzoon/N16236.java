package baekzoon;

import java.util.*;

//https://mygumi.tistory.com/339
//https://www.acmicpc.net/problem/16236
// 삼성 기출문제. 엄청 어렵다.
public class N16236 {
	static int l;
	static boolean[] visit = new boolean[400];
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int sharkX, sharkY, sharkSize = 2, time = 0 ,cnt;
	static ArrayList<Item> fish = new ArrayList<Item>();

	static class Item {
		int x;
		int y;
		int n;
		int move;

		public Item(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.n = this.y * l + this.x;
			this.move = move;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		map = new int[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sharkX = j;
					sharkY = i;
				}
			}
		}
		while (true) {
			Queue<Item> q = new LinkedList<>();
			fish = new ArrayList<>();
			visit = new boolean[400];
			q.add(new Item(sharkX, sharkY, 0));
			visit[sharkY * l + sharkX] = true;
			int found = -1;
			while (!q.isEmpty()) {
				Item item = q.poll();
				int sy = item.n / l;
				int sx = item.n % l;
				int move = item.move;
				if (found == move)
					break;
				for (int i = 0; i < 4; i++) {
					int nx = sx + dx[i];
					int ny = sy + dy[i];
					int next = ny * l + nx;
					if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
						if (visit[next])
							continue;
						visit[next] = true;
						if (sharkSize >= map[ny][nx]) {
							if (map[ny][nx] > 0 && sharkSize > map[ny][nx]) {
								found = move + 1;
								fish.add(new Item(nx, ny, move + 1));
							}
							q.add(new Item(nx, ny, move + 1));
						}
					}
				}
			}
			if (found == -1) {
				break;
			} else {
				if (fish.size() > 1) {
					Collections.sort(fish, new ySort());
				}
			}
			Item fis = fish.get(0);
			if (found != -1) {
				time += found;
				map[sharkY][sharkX] = 0;
				sharkX = fis.x;
				sharkY = fis.y;
				map[sharkY][sharkX]=9;
				if(sharkSize== ++cnt) {
					sharkSize++;
					cnt=0;
				}
			}
		}
		System.out.println(time);
	}

	static class ySort implements Comparator<Item> {

		@Override
		public int compare(Item i1, Item i2) {
			if (i1.y < i2.y) {
				return -1;
			} else if (i1.y == i2.y) {
				if (i1.x < i2.x)
					return -1;
				else if (i1.x == i2.x)
					return 0;
				return 1;
			} else
				return 1;
		}

	}
}
