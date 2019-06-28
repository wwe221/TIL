package solution;

import java.util.*;

public class Prac {
	public static class number implements Comparable<number> {
		int getin; // 들어오는 시간
		int time; // 걸리는 시간

		public number(int getin, int time) {
			this.getin = getin;
			this.time = time;
		}

		public int getGetin() {
			return getin;
		}

		public int getTime() {
			return time;
		}
		@Override
		public int compareTo(number target) {
	        return this.time >= target.time ? 1 : - 1;
	    }

		@Override
		public String toString() {
			return "number [getin=" + getin + ", time=" + time + "]";
		}
	}

	public static void main(String[] args) {
		int[][] jobs = { { 4, 8 }, { 2, 7 }, { 2, 3 }};
		int l = jobs.length;
		PriorityQueue<number> wait = new PriorityQueue<>();
		// 수행 시간 순으로 정렬한 큐
		PriorityQueue<number> allq = new PriorityQueue<>(l, new Comparator<number>() {
			// 요청 시간 순으로 정렬한 큐
			@Override
			public int compare(number p1, number p2) {
				return p1.getin >= p2.getin ? 1 : -1;
			}
		});
		number going = null; // 지금 실행중인 작업.
		int ttime = 0; // 지나간 시간
		int answer = 0;
		int ind = 0;
		for (int i = 0; i < l; i++) { // 모든 작업들을 요청시간 순으로 정렬 해서 넣는다.
			wait.offer(new number(jobs[i][0], jobs[i][1]));
		}
		System.out.println(wait);
		
		// 수행 요청 시간이 지났다면 그것을 수행시간 순으로 wait에 넣는다.
		while (!allq.isEmpty() || !wait.isEmpty()) {
			for (int i = 0; i < allq.size(); i++) {
				if (ttime >= allq.peek().getin) {
					wait.add(allq.poll());
					
				}				
			}
			going = wait.poll(); // 다음 순서 녀석을 넣는당.
			int tmp = going.time + ttime - going.getin;
			ttime += going.time;
			answer += tmp;
			going = null;
		}
		System.out.println(wait);
		System.out.println(answer/3);

// 		while (ind < l) {
//			for (int i = ind; i < l; i++) {
//				if (ttime >= jobs[ind][0]) {
//					wait.add(new number(jobs[ind][0], jobs[ind][1]));
//					ind++;
//				}
//			}
//			going = wait.poll(); // 다음 순서 녀석을 넣는당.
//			int tmp = going.time + ttime - going.getin;
//			ttime += going.time;
//			answer += tmp;
//			going = null;
//
//		}
//		System.out.println(wait);
//		going = wait.poll();
//		int tmp = going.time + ttime - going.getin;
//		answer += tmp;
//		System.out.println(answer / l);

	}

}
