package lesson;

import java.util.Arrays;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++)
			arr[i] = ran.nextInt(89) + 10;
		int [] ase = arr;
		int [] dse = arr;
		int tmp =0;
		System.out.println(Arrays.toString(arr));
		for (int i=0;i<10;i++) {
			for(int j=0; j<10;j++) {
				if(ase[i]<ase[j]) {
					tmp  = ase[i];
					ase[i] = ase[j];
					ase[j] = tmp;
				}					
			}
		}
		System.out.println(Arrays.toString(ase));		
		for (int i=0;i<10;i++) {
			for(int j=0; j<10;j++) {
				if(dse[i]>dse[j]) {
					tmp  = dse[i];
					dse[i] = dse[j];
					dse[j] = tmp;
				}					
			}
		}
		System.out.println(Arrays.toString(dse));
	}

}
