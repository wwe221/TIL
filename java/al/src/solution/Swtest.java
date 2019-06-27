package solution;

import java.util.ArrayList;

public class Swtest {
	public static class car {
		int weight; // 무게
		int dis; // 남은 길이

		public car(int a, int b) {
			this.weight = a;
			this.dis = b;
		}
	}

	public static void main(String[] args) {
		int bl = 100;
		int w = 100;
		int[] tw = { 10};
		int[] bir = new int[bl];
		ArrayList<car> wait = new ArrayList<>(); // 대기중인 차
		ArrayList<car> going = new ArrayList<>();// 다리위의 차
		for (int i = 0; i < tw.length; i++) {
			wait.add(new car(tw[i], bl));
		}
		int onb = 0; // 다리위 차들의 무게
		int answer = 0;
		while (!wait.isEmpty() || !going.isEmpty()) { // 다리위의 차와 대기중인 차가 모두 사자리면 그만둔다.
			
			// 다음 대기중인 차의 무게가 들어와도 괜찮을때만 차를 다리에 올린다.
			if (!wait.isEmpty() && onb + wait.get(0).weight <= w) {
				onb += wait.get(0).weight;
				going.add(wait.remove(0));
			}
			// 다리 위에 존재하는 차들앞으로 밀고, 끝가지 도착 했다면 remove 한다.
			for (int i = 0; i < going.size(); i++) {
				int newdis = going.get(i).dis - 1;
				if (newdis == 0) {
					onb -= going.get(i).weight;
					going.remove(i);
				} else
					going.set(i, new car(going.get(i).weight, newdis));
			}
			answer++; // 시간 증가
		}
		System.out.println(answer);
	}
}
