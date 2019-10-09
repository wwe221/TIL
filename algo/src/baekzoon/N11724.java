package baekzoon;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11724
public class N11724 {
	static int n;
	static int m;
	static int[][] map;
	static int[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][n+1];
		v= new int[n+1];
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		for(int i=1;i<n+1;i++) {
			if(v[i]==0) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int idx) {
		v[idx]=1;
		for(int i=1;i<n+1;i++) {
			if(v[i]==0 &&map[idx][i]==1) {
				dfs(i);
			}
		}
	}

}
