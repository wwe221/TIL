package baekzoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2606
public class N2606 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int ll;
		for (int i = 0; i <=l; i++) {
			list.add(new ArrayList<>());
		}
		ll = sc.nextInt();
		for (int i = 0; i <ll; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			list.get(m).add(n);
			list.get(n).add(m);
		}
		boolean[] c = new boolean[l + 1];
		q.add(1);
		int u = 0;
		while (!q.isEmpty()) {
			u = q.poll();
			for (int tmp : list.get(u)) {
				if (!c[tmp]) {
					c[tmp] = true;
					q.add(tmp);
				}
			}
		}
		int cnt =-1;
		for(boolean tmp:c) {
			if(tmp)
				cnt++;
		}
		System.out.println(cnt);
	}

}
