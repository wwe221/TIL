package programmers;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42583
public class BridgePassTruck {

	public static void main(String[] args) {
		int[] tw = { 7, 4, 5, 6 };
		System.out.println(solution(2, 10, tw));
	}

	public static int solution(int length, int weight, int[] tw) {
		Queue<Truck> wait = new LinkedList<>();
		Queue<Truck> onB = new LinkedList<>();
		int l = tw.length;
		int nowW = 0;
		for(int w:tw) {
			Truck t = new Truck(w, 0);
			wait.add(t);
		}
		int sec=0;
		while(!wait.isEmpty() || !onB.isEmpty()) {
			sec++;
			Truck done = null;
			int sum=0;
			for(Truck t : onB) {
				sum+= t.weight;
				t.position++;
				if(t.position> length) {
					done = t;
				}
			}
			if(done != null) {
				onB.remove(done);
				sum-=done.weight;
			}
			if(!wait.isEmpty() && onB.size() < length) {
				Truck truck = wait.peek();
				if(truck.weight + sum <= weight) {
					wait.remove(truck);
					onB.add(truck);
					truck.position++;
				}
			}
		}
		return sec;
	}

	public static class Truck {
		int weight;
		int position;

		public Truck(int weight, int position) {
			this.weight = weight;
			this.position = position;
		}

	}
}
