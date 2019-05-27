package array1;

import java.util.Random;

public class Arr1 {
	public static void main(String[] args) {
		int[] a = new int[9];
		Random ran = new Random();
		int r;
		int [] j = new int[10];
		for (int i = 0; i < a.length; i++) {
			while(true) {
				r = ran.nextInt(9) + 1;
				if(j[r] == 0) {		
					j[r]=1;
					a[i]=r;
					break;
				}
				else if(j[r]==1)
					continue;		
			}
		}
		for (int i : a) {
			System.out.printf("%d ", i);
		}
	}
}
