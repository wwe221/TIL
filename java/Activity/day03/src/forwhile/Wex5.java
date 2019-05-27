package forwhile;

public class Wex5 {

	public static void main(String[] args) {
		int i = 0xA - 10;
		int sum = 0;
//		while (i++ < 10) {
//			if (i == 6)
//				break;
//			if (i % 2 == 0)
//				continue;
//			sum += i;
//		}
//		System.out.println(sum);
		i = 0;
		sum = 0;
		for (i = 1; i < 10; i++) {
			if (i == 6)
				break;
			if (i % 2 == 0)
				continue;
			sum += i;
		}
		System.out.println(sum);
	}	
	
}
