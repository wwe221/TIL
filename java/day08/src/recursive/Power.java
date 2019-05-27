package recursive;

public class Power {

	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		int result = 0;
		result = power(x, n);
		System.out.println(result);

	}

	private static int cub(int n, int m) {//nÀÇ m½Â
		if (m <= 1)
			return n;
		return n * cub(n, m - 1);
	}

	private static int power(int x, int n) { // x^n + x^(n-1) + .....
		int result = 0;
		for (int i = n; i >= 1; i--)
			result += cub(x, i);

		return result;

	}

}
