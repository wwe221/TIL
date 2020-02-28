package baekzoon;

import java.util.Arrays;
import java.util.Scanner;

public class N11403 {
	static int [][] map;
	static int [][] map2;
	static int l;
	static int [] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = new int [l];
		map = new int[l][l];
		map2 = new int[l][l];
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				map[i][j]= sc.nextInt();
			}
		}
		for(int i=0;i<l;i++) {
			dfs(c,i);
			for(int j=0;j<l;j++) {
				map2[i][j]=c[j];
			}
			c= new int[l];
		}
		for(int a[] : map2) {
			System.out.println();
			for(int tmp : a)
				System.out.print(tmp + " ");
		}
	}
	static void dfs(int []c , int target) {
		for(int i=0;i<l;i++) {
			if(map[target][i]==1 && c[i]==0) {
				c[i]=1;
				dfs(c,i);
			}
		}
	}
}