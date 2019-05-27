package forwhile;

public class Wex4 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		while ((sum += ++i) <= 100) {
			System.out.println(i + " " + sum);
		}
		for (sum = 0, i = 0; (sum += ++i) <= 100;)
			System.out.println(i + " " + sum);
	}
	

}
