package baekzoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//https://www.acmicpc.net/problem/16637
public class N16637 {
	static int l;
	static int[] numbers;
	static int[] tmp;
	static char[] opers;
	static boolean[] c;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		String str = sc.next();
		numbers = new int[l / 2 + 1];
		opers = new char[l / 2];
		c = new boolean[l / 2];
		tmp = new int[l / 2];
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < l; i++) {
			if (i % 2 == 0) {
				numbers[cnt++] = str.charAt(i) - '0';
			} else {
				opers[cnt2++] = str.charAt(i);
			}
		}
		for (int tmp : numbers) {
			System.out.print(tmp + " ");
		}
		for (char tmp : opers) {
			System.out.print(" " + tmp);
		}
		c[1] = true;
		c[3] = true;
		getMax(c);
		System.out.println(max);
	}

	static void dfs(int idx, boolean[] check) {
		if (idx == l / 2) { // 끝까지 들어 왔으면 max를 구한다.
			return;
		}
		if(idx==0) {
			
		}		
		if (!check[idx + 1] || !check[idx - 1]) { // 근접한 연산자에 괄호가 사용 돼지 않았으면 작업 시작
			check[idx] = true;

		}
	}

	static void getMax(boolean[] check) {
		ArrayList<Integer> numb = new ArrayList<>();
		Queue<Character> ops = new LinkedList<>();
		for (int i = 0; i < l / 2; i++) {
			if (check[i]) {
				char c = opers[i];
				switch (c) {
				case '+':
					tmp[i] = numbers[i] + numbers[i + 1];
					break;
				case '-':
					tmp[i] = numbers[i] - numbers[i + 1];
					break;
				case '*':
					tmp[i] = numbers[i] * numbers[i + 1];
					break;
				}
				System.out.println(tmp[i]);
			}
		}
		for (int i = 0; i < l / 2; i++) {
			if (check[i]) {
				numb.add(tmp[i]);
			} else {
				numb.add(numbers[i]);
				ops.add(opers[i]);
			}
		}
		for(int tp : numb)
			System.out.print(tp+" ");
		for(char tp : ops)
			System.out.print(tp);
		
		while (numb.size() != 1) {
			int a = numb.get(0);
			char c = ops.poll();
			int b = numb.get(1);
			numb.remove(0);
			int tmp = 0;
			switch (c) {
			case '+':
				tmp = a + b;
				break;
			case '-':
				tmp = a - b;
				break;
			case '*':
				tmp = a * b;
				break;
			}
			numb.set(0, tmp);
		}
		int m = numb.get(0);
		if (m > max)
			max = m;

	}
}
