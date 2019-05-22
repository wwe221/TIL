package forwhile;

public class Forex2 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == i)
					System.out.print("¹«½ÂºÎ ");
				else if (i - j == -1 || i - j == 2)
					System.out.print("ÄÄ½Â ");
				else
					System.out.print("À¯Àú½Â ");
			}
			System.out.println();
		}
	}
}
