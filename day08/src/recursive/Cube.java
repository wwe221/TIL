package recursive;

public class Cube {
	public static void main(String[] args) {
		int x= 2;
		int n = 3;
		int result = cub(2,3);
		System.out.println(result);
	}

	private static int cub(int n, int m) {
		if(m<=1)
			return n;
		return n * cub(n,m-1);
	}

}
