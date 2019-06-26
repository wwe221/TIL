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
		int bw = 2; // 길이
		int w = 10; // 최고 무게
		int[] tw = { 7, 4, 5, 6 };// 각 차의 무게
		ArrayList<Integer> arr = new ArrayList<>(); // 모든 차를 넣는당
		int cnt = 0; //다음 들어갈 차의 인덱스
		for (int i = 0; i < tw.length; i++) {
			arr.add(tw[i]);
		}
		int index =0;
		ArrayList<car> cars = new ArrayList<>(); // 다리위를 지나는 차
		int answer = 0;
		while(!arr.isEmpty()) {
			if(weight(cars)+arr.get(index) < w) {
				car c = new car(arr.get(index),bw);
				cars.add(c);				
			}
			for(int i=0;i<cars.size();i++) {
				int dis = cars.get(i).dis;
				dis--;				
				cars.set(i, new car(cars.get(i).weight,dis));
				if(cars.get(i).dis==0) {
					cars.remove(i);
				}
				answer++;
			}			
		}
	}
	public static int weight(ArrayList<car> c) { // 다리 위의 모든 차 무게 계산
		int a = 0;
		int l = c.size();
		for (int i = 0; i < l; i++) {
			a += c.get(i).weight;
		}
		return a;
	}

}
