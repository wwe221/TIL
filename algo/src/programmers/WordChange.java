package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/43163
public class WordChange {
	static boolean[] v;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		String temp = begin;
		int num = 0;
		ArrayList<Integer>[] list = new ArrayList[words.length + 2];
		int count = 0;
		for (int j = 0; j < words.length + 1; j++) {
			list[j] = new ArrayList<Integer>();

			for (int m = 0; m < words.length; m++) {
				count = 0;
				for (int i = 0; i < temp.length(); i++) {
					if (temp.charAt(i) != words[m].charAt(i)) {
						count++;
					}
				}
				if (count == 1) {
					list[j].add(m + 1);
				}
			}

			if (j < words.length) {
				temp = words[j];
				if (target.equals(words[j]))
					num = j + 1;
			}
		}
		
		if (num == 0) {
			return 0;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int[] d = new int[words.length + 2];
		Arrays.fill(d, -1);

		d[0] = 0;
		q.add(0);
		int u = 0;
		while (q.size() > 0) {
			u = q.poll();
			for (int e : list[u]) {
				if (d[e] == -1) {
					d[e] = d[u] + 1;
					q.add(e);
				}
			}
			if (num == u) {
				break;
			}

		}
		return d[num];
	}
}
