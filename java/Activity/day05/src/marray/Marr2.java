package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr2 {

	public static void main(String[] args) {
//		int ma[][]= {
//				{1,2,3,4,5,},
//				{6,5,4,},
//				{2,4,5,7}
//		};
		int ma[][]= new int[3][];
		ma[0]= new int[4];
		ma[1]= new int[6];
		ma[2]= new int[2];
		Random ran = new Random();
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j <ma[i].length; j++) {
				ma[i][j] = ran.nextInt(10);
			}
		}
		for (int i[] : ma) {			
			
			System.out.println(Arrays.toString(i));
		}
	}

}
