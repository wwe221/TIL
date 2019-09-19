package bjalgo;

import java.util.Scanner;

public class OperatorAdd {
	static int [] numbs;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) {
		int plus, minus, mult, div;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbs = new int [n];
		for(int i=0;i<n;i++) {
			numbs[i]=sc.nextInt();
		}
		plus = sc.nextInt();
		minus = sc.nextInt();
		mult = sc.nextInt();
		div = sc.nextInt();
		go(1,numbs[0],plus,minus,mult,div);
		System.out.println(max);
		System.out.println(min);
	}
	static void go(int cnt,int sum, int plus, int minus, int mult , int div) {		
		if(cnt == n) {	
			if(sum>max)
				max = sum;
			if(sum<min)
				min = sum;
			return;
		}
		if(plus>0) 
			go(cnt+1,sum+numbs[cnt],plus-1,minus,mult,div);			
		if(minus>0) 
			go(cnt+1,sum-numbs[cnt],plus,minus-1,mult,div);			
		if(mult>0) 
			go(cnt+1,sum*numbs[cnt],plus,minus,mult-1,div);			
		if(div>0) 
			go(cnt+1,sum/numbs[cnt],plus,minus,mult,div-1);			
	}
}
