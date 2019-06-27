package solution;

import java.util.*;

public class Prac {
	public static void main(String[] args) {
		int stock = 4;
		int[] dates = { 4, 10, 15 };
		int[] supp = { 20, 5, 10 };
		int answer = 0;
		int l = dates.length;
		int k = 30;
		int days = 1;
		int ind = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		// 오늘 까지 보급 받을수 있는 것을 내림차순 정렬
		while (days < k) { // 30일날 까지
			days++; // 다음날
//9일째에 밀가루가 바닥나더라도, 10일째에 공급받으면 10일째에는 공장을 운영할 수 있습니다.
//밀가루가 0이라면,
			stock--;
			if (days >= dates[ind] && ind < l - 1) {// 만약 보급날이 지난다면 보급량을 q에 넣는다.
				q.add(supp[ind]);
				ind++;
			}
			if (stock < 0) { // 쌀이 다 떨어지면 가장 큰 보급품으로 채워 넣는다.
				System.out.println(days);
				stock += q.poll();
				answer++;
			}
		}
		System.out.println(answer);
	}
}
