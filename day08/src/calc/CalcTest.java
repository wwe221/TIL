package calc;

import java.util.Arrays;

public class CalcTest {

	public static void main(String[] args) {
		int []arr = { 1,4,15,7,5,3,6};		
		Calc myc = new Calc(arr);
		System.out.println(myc.sum());
		System.out.println(myc.avg());
		System.out.println(Arrays.toString(myc.asort()));
		System.out.println(Arrays.toString(myc.dsort()));

	}

}
