package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr4 {

	public static void main(String[] args) {
		int[] a = new int[30];
		Random ran = new Random();		
		for (int i = 0; i < a.length; i++) {			
			a[i] = ran.nextInt(4)+1;
		}
		int []cnt= new int [4+1];
		for(int i:a)
			cnt[i]++;
		System.out.println(Arrays.toString(a));
		for(int i=1;i<cnt.length;i++)
			System.out.printf("%d : %d\n",i,cnt[i]);
	}

}
