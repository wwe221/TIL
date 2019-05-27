package day02;

public class Operator4 {

	public static void main(String[] args) {
		String result = "";
		int a = 10;
		int b = 20;
//		if (a > b) {
//			result = "A";
//		} else {
//			result = "B";
//		}
		result = a > b ? "a" : "b";
		System.out.println(result);

		int i1 = 20, i2 = 30, i3 = 10;
		int max = 0;
		max = i1 > i2 ? (i1 > i3) ? i1 : i3 : (i2 > i3) ? i2 : i3;
		System.out.println(max);
		

	}

}
