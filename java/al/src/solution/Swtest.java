package solution;

import java.util.Stack;

public class Swtest {

	public static void main(String[] args) {
		int[] prog = { 93, 30, 55 };// 진도
		int[] speeds = { 1, 30, 5 };// 진행률
		int l = prog.length;
		int[] day = new int[l];
		int[] answer;
		for (int i = 0; i < l; i++) {
			int a = (100 - prog[i]) % speeds[i];
			int b = (100 - prog[i]) / speeds[i];
			if (a > 0)
				day[i] = b + 1;
			else
				day[i] = b;
		}
		for (int i : day)
			System.out.print(i+ " ");
		System.out.println();
		
	}
}
