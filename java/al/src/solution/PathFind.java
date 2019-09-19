package solution;

import java.util.ArrayList;
import java.util.Scanner;

public class PathFind {
	static int[][] answer;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = new int [n][n];
		int[][] map = new int[n][n];
		int [] visit;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			visit = new int [n];
			dfs(map,visit,i);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}

	public static void dfs(int [][]map , int [] visits , int now) {		
		for(int i=0;i<n;i++) {
			if(map[now][i]==1 && visits[i]==0) {
				visits[i]=1;
				System.out.println(now + "@@");
				answer[now][i]=1;
				dfs(map,visits,i);
			}
		}
	}
}
