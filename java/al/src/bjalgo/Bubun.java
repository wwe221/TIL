package bjalgo;

import java.util.ArrayList;
import java.util.Scanner;

public class Bubun {
	static boolean made[];
	static int n;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		made= new boolean[1000000000];
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list= new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		go(0,0);
		int a=0;
		while(true) {
			if(made[a]==false)
				break;
			a++;
		}
		System.out.println(a);
		
	}
	static public void go(int i, int sum) {
		made[sum]=true;
		if(i==n)
			return;
		go(i+1,sum+list.get(i));
		go(i+1,sum);		
		
	}

}
