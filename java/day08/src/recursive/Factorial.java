package recursive;

public class Factorial {

	public static void main(String[] args) {
		int n = 5;
		int re = 0;
		re = factorial(n);
		System.out.println(re);
	}

	static int factorial(int n) {
		int result = 0;
		if (n <= 1)
			return 1;
		else
			result = n * factorial(n - 1);
		return result;
	}

}
