package programmers;

public class _2xnTile {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	public static int solution(int n) {
		int[] wh = new int[n + 1];
		int s = 1000000007;
		wh[0] = 1;
		wh[1] = 1;
		for (int i = 2; i <= n; i++) {
			wh[i] = (wh[i - 1] + wh[i - 2]) % s;
		}
		// System.out.println("wh["+ n + "] : "+ wh[n]);
		return wh[n];
	}
}
