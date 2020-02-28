package mlCT;

public class N3 {

	public static void main(String[] args) {

		int[] p = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
		System.out.println(solution(10, p));
	}

	static int solution(int n, int[] prices) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int sold = prices[i];
			for (int j = i + 1; j < n; j++) {
				int buy = prices[j];
				if (sold - buy > max) {
					max = sold - buy;
				}
			}
		}
		answer = max;
		int inf = 1000000001;
		int mn = -inf;
		int mx = inf;
		for(int p: prices) {
			if(mn != inf) {
				mx = Math.min(mx, p-mn);
			}
			mn = Math.max(mn, p);
		}
		System.out.println(-mx+" ");
		return answer;
	}

}
