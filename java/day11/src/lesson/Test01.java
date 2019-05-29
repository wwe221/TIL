package lesson;

public class Test01 {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		while (i <= 10) {
			j = 0;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}

	}

}
