package day01;

//Java Application
public class Variable1 {
	public static void main(String[] args) {
		// Type, Initial
		// local Variable
		int a = 10, b = 20, c = 30;
		int temp = 0;
//		if (a < b && a < c)
//			temp = a;
//		else if (b < a && b < c)
//			temp = b;
//		else
//			temp = c;
		if (a > b) {
			temp = a;
			if (temp < c)
				temp = c;
		} else {
			temp = b;
			if (temp < c)
				temp = c;
		}
		System.out.print(temp);
	}
}