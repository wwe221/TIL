package lesson;
public class Test02 {
	public static void main(String[] args) {
		int a = 0, b = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.printf("%d + %d = 6\n", i, j);
				}
			}
		}
	}
}
