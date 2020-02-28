package baekzoon;

import java.util.LinkedList;
import java.util.Queue;

public class Socar2 {
	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 3, 1, 0, 5 };
		System.out.println(solution(nums));
	}
	static int answer = Integer.MAX_VALUE;

	private static int solution(int[] nums) {
		int des = nums.length - 1;
		dfs(nums, 0, 0, des, 0);
		return answer;
	}

	static void dfs(int[] numbs, int cnt, int idx, int des, int b4) {
		if (idx < 0 || idx > des) {
			return;
		}
		if (idx == des) {
			if (cnt < answer) {
				answer = cnt;
			}
			return;
		}
		int jump = numbs[idx];
		if (jump != 0) {
			if (idx + jump != b4) {
				dfs(numbs, cnt + 1, idx + jump, des, idx);
			}
			if (idx - jump != 0 && idx - jump != b4) {
				dfs(numbs, cnt + 1, idx - jump, des, idx);
			}

		}
	}
}
