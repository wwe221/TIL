package bjalgo;

import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {
	static int n;
	static ArrayList<Integer> list;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		while(true) {
			list = new ArrayList<>();
			n = sc.nextInt();
			if(n==0)
				return;			
			for(int i=0;i<n;i++) {
				list.add(sc.nextInt());
			}
			go(arr,0,0);
			System.out.println("다음");
		}
	}
	public static void go(ArrayList<Integer> arr, int depth, int ind) {
		if(depth == 6) {//1.처리될 문장
			for(int temp : arr)
				System.out.print(temp+" ");
			System.out.println();
			return;
		}
		if(ind>=n)//2.조건.
			return;
		arr.add(list.get(ind));
		go(arr,depth+1,ind+1);
		arr.remove(arr.size()-1);
		go(arr,depth,ind+1);
	}
		

}
