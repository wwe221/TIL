package array1;

import java.util.Arrays;

public class Sarr1 {

	public static void main(String[] args) {
		int[]a= {3,5,4};
		String str = "HiHello";
		char [] c =str.toCharArray();
		for(int i=0;i<str.length();i++) {
			c[i] = (char) (c[i]+3);
		}
		System.out.println(Arrays.toString(c));
		String str2 = new String(c);
		System.out.println(str2);
		
		

	}

}
