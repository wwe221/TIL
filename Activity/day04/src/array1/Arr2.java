package array1;

import java.util.Arrays;

public class Arr2 {

	public static void main(String[] args) {
		int[] a = new int[5];
		int[] b = { 1,5,3};
		int[] c = { 7,8,9,2,4,0};
//		for(int i =0;i<b.length;i++)
//			c[i]=b[i];		
		System.arraycopy(b, 1, c, 3, 2);
		System.out.println(Arrays.toString(c));
	}

}
