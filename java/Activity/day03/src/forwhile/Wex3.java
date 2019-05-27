package forwhile;

public class Wex3 {

	public static void main(String[] args) throws InterruptedException {
		int i = 5;
		while (i-- != 0) {
			Thread.sleep(1000);
			System.out.println(i);
		}
	}

}
