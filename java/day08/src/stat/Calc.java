package stat;

public class Calc {	
	public static int test = 10;
	public static int sum(int a, int b) {
		return (a + b);
	}
	public static int sum(int a[]) {
		int sum =0;
		for(int i : a)
			sum+=i;
		return sum;
	}
	
}
