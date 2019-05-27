package forwhile;

public class Wex6 {

	public static void main(String[] args) {
		int result = 0;
		int flag = 0;
		hi: for (int i = 2; i < 10; i++) {
			if (i % 2 == 0)
				continue;
			for (int j = 1; j < 10; j++) {
				result = i * j;
				if (result == 49) {
					break hi;
				}
				System.out.printf("%d x %d = %d\n", i, j, result);
			}
		}
		System.out.println();
	}
}
