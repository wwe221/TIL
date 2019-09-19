package bjalgo;

import java.util.Scanner;

public class DeungcharSum {
	static int n , m;
	static int []numbs;
	static int ans =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbs = new int [n];
		for(int i=0;i<n;i++) {
			numbs[i]=sc.nextInt();
		}
		go(0,0);
		if(m == 0 )
			ans--;
		System.out.println(ans);
	}
	static void go(int i , int sum) {
		if(i == n) {
			if(sum == m) {
				ans ++;
			}
			return;
		}
		go(i+1,sum+numbs[i]);
		go(i+1,sum);
	}

}
