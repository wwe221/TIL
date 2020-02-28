package baekzoon;

import java.util.ArrayList;

public class Socar3 {

	public static void main(String[] args) {
		int[][] paths = { { 1, 2 }, { 10, 9 },{ 3, 4 },{2,3},{4,5} };
		System.out.println(soultion(paths));
	}
	private static int[] soultion(int[][] paths) {	
		ArrayList<P> list = new ArrayList<>();
		int l = paths.length;
		P pp = null;
		for (int i = 0; i < l; i++) {
			int a = paths[i][0];
			int b = paths[i][1];
			boolean flag = false;
			boolean check = false;
			for (P tmp : list) {
				if (tmp.y == a) {
					if(check) {
						pp.x=tmp.x;
						list.remove(tmp);
					}
					tmp.y = b;
					flag = true;
					pp= tmp;		
					check = true;
				} else if (tmp.x == b) {
					if(check) {
						pp.y=tmp.y;
						list.remove(tmp);
						continue;
					}
					tmp.x = a;
					flag = true;
					pp=tmp;
					check= true;
				}
			}
			if(!flag) {
				list.add(new P(a,b));
			}			
		}
		int size = list.size();
		int[] answer = new int[size*2];
		int idx=0;
		for(int i=0;i<size;i++) {
			answer[idx++]=list.get(i).x;
			answer[idx++]=list.get(i).y;
		}
		System.out.println(list);
		return answer;
	}

	public static class P {
		int x;
		int y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "P [x=" + x + ", y=" + y + "]";
		}
		

	}
}
