package mlCT;

import java.util.ArrayList;

public class N5 {

	public static void main(String[] args) {
		int[][] m = { { 1, 2 }, { -2, -1 }, { 1, -2 }, { 3, -1 } };
		int[][] b = { { 1, 0 }, { 2, 1 } };
		System.out.println(solution(m, b));
	}

	static class M {
		int x;
		int y;

		public M(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	public int solution2(int[][] monsters, int[][] bullets) {
        int answer = 0;
		int cnt = 0;
		int bl = bullets.length;
		int ml = monsters.length;
		for (int i = 0; i < bl; i++) {
			double bx = bullets[i][0];
			double by = bullets[i][1];
			if (bx != 0 && by != 0) {
				double tmp = bx / by;
				for (int j = 0; j < ml; j++) {
					double mx = monsters[j][0];
					double my = monsters[j][1];
                    if(mx==0 &&my==0)
						continue;
					double mtmp = mx / my;
					if (bx > 0 && mx > 0) {
						if (by > 0 && my > 0) { // 1사분면
							if (tmp == mtmp) {
								monsters[j][0] = 0;
								monsters[j][1] = 0;
								cnt++;
								break;
							}
						} else if (by < 0 && my < 0) {// 4사분면
							if (tmp == mtmp) {
								monsters[j][0] = 0;
								monsters[j][1] = 0;
								cnt++;
								break;
							}
						}
					} else if (bx < 0 && mx < 0) {
						if (by > 0 && my > 0) { // 2사분면
							if (tmp == mtmp) {
								monsters[j][0] = 0;
								monsters[j][1] = 0;
								cnt++;
								break;
							}
						} else if (by < 0 && my < 0) {// 3사분면
							if (tmp == mtmp) {
								monsters[j][0] = 0;
								monsters[j][1] = 0;
								cnt++;
								break;
							}
						}
					}
				}
			} else {
				if (bx == 0) {//x축
					if (by > 0) {
						for (int j = 0; j < ml; j++) {
							double mx = monsters[j][0];
							double my = monsters[j][1];
							if (mx == 0 && my > 0) {
								monsters[j][1] = 0;
								cnt++;
								break;
							}
						}
					} else {
						for (int j = 0; j < ml; j++) {
							double mx = monsters[j][0];
							double my = monsters[j][1];
							if (mx == 0 && my < 0) {
								monsters[j][1] = 0;
								cnt++;
								break;
							}
						}
					}
				}
				if (by == 0) {//y축
					if (bx > 0) {
						for (int j = 0; j < ml; j++) {
							double mx = monsters[j][0];
							double my = monsters[j][1];
							if (my == 0 && mx > 0) {
								monsters[j][0] = 0;
								cnt++;
								break;
							}
						}
					} else {
						for (int j = 0; j < ml; j++) {
							double mx = monsters[j][0];
							double my = monsters[j][1];
							if (my == 0 && mx < 0) {
								monsters[j][0] = 0;
								cnt++;
								break;
							}
						}
					}
				}
			}
		}
		if (cnt == 0)
			return -1;
		else
			return cnt;
    }
	public static int solution(int[][] monsters, int[][] bullets) {
		int answer = 0;
		int cnt = 0;
		int bl = bullets.length;
		int ml = monsters.length;
		ArrayList<M> list = new ArrayList<>();
		for(int i=0;i<ml;i++) {
			list.add(new M(monsters[i][0],monsters[i][1]));
		}
		int listL = list.size();
		for (int i = 0; i < bl; i++) {
			double bx = bullets[i][0];
			double by = bullets[i][1];
			listL=list.size();
			if (bx != 0 && by != 0) {
				double tmp = bx / by;
				for (int j = 0; j < listL; j++) {
					double mx = list.get(j).x;
					double my = list.get(j).y;
					if (mx == 0 && my == 0)
						continue;
					double mtmp = mx / my;
					if (bx > 0 && mx > 0) {
						if (by > 0 && my > 0) { // 1사분면
							if (tmp == mtmp) {
								list.remove(j);
								cnt++;
								break;
							}
						} else if (by < 0 && my < 0) {// 4사분면
							if (tmp == mtmp) {
								list.remove(j);
								cnt++;
								break;
							}
						}
					} else if (bx < 0 && mx < 0) {
						if (by > 0 && my > 0) { // 2사분면
							if (tmp == mtmp) {
								list.remove(j);
								cnt++;
								break;
							}
						} else if (by < 0 && my < 0) {// 3사분면
							if (tmp == mtmp) {
								list.remove(j);
								cnt++;
								break;
							}
						}
					}
				}
			} else {
				if (bx == 0) {
					if (by > 0) {
						for (int j = 0; j < listL; j++) {
							double mx = list.get(j).x;
							double my = list.get(j).y;
							if (mx == 0 && my > 0) {
								list.remove(j);
								cnt++;
								break;
							}
						}
					} else {
						for (int j = 0; j < listL; j++) {
							double mx = list.get(j).x;
							double my = list.get(j).y;
							if (mx == 0 && my < 0) {
								list.remove(j);
								cnt++;
								break;
							}
						}
					}
				}
				if (by == 0) {
					if (bx > 0) {
						for (int j = 0; j < listL; j++) {
							double mx = list.get(j).x;
							double my = list.get(j).y;
							if (my == 0 && mx > 0) {
								list.remove(j);
								cnt++;
								break;
							}
						}
					} else {
						for (int j = 0; j < listL; j++) {
							double mx = list.get(j).x;
							double my = list.get(j).y;
							if (my == 0 && mx < 0) {
								list.remove(j);
								cnt++;
								break;
							}
						}
					}
				}
			}
		}
		if (cnt == 0)
			return -1;
		else
			return cnt;
	}
}
