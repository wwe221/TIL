package calc;

import java.util.Arrays;
import java.util.Random;

public class test {

	public static void main(String[] args) {

		Random ran = new Random();
		int[] B = new int[5];
		boolean[] a = new boolean[10];
		int r;
		for (int i = 0; i < 5; i++) {
			r = ran.nextInt(9) + 1;
			if (a[r] == false) {
				B[i] = r;
				a[r] = true;
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println();		
		System.out.println(Arrays.toString(B));
	}

}
