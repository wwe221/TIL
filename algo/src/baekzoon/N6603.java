package baekzoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N6603 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		while(true) {
			int n = sc.nextInt();
			if(n==0)
				break;
			ArrayList<Integer>list = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				list.add(sc.nextInt());
			}			
			dfs(arr,list,0,0,n);
			System.out.println();
		}
	}
	static void dfs(ArrayList<Integer> arr, ArrayList<Integer> list,int depth, int idx, int n) {
		if(depth==6) {
			for(int tmp : arr) {
				System.out.print(tmp+" ");
			}
			System.out.println();
			return;
		}
		if(idx>=n)
			return;
		arr.add(list.get(idx));
		dfs(arr,list,depth+1,idx+1,n);
		arr.remove(arr.size()-1);
		dfs(arr,list,depth,idx+1,n);
		
	}

}
