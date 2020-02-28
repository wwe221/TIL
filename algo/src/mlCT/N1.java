package mlCT;


import java.util.*;

public class N1 {

	public static void main(String[] args) {
		int[] waiting = { 1, 5, 8, 2, 10, 5, 4, 6, 4, 8 };
		System.out.println(solution(waiting));
	}

	static int[] solution(int[] waiting) {
		int l = waiting.length;
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer,Boolean> map = new HashMap<>();
		for (int i = 0; i < l; i++) {
			int a = waiting[i];
			if(map.get(a)!=null) {
				continue;
			}
			else {
				map.put(a,true);
				list.add(a);
			}
		}
		int[] answer = new int[list.size()];
		int idx =0;
		for(int tmp : list) {
			answer[idx++]=tmp;
			System.out.println(tmp);
		}
		return answer;
	}

}
