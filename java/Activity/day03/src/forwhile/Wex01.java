package forwhile;

public class Wex01 {

	public static void main(String[] args) {
//		for (int i = 1; i <= 10; i++) {
//			System.out.println(i);
//		}
		int i = 0;
//		while (i <= 10) {
//			System.out.println(i);
//			i++;
//		}
		for(int a=0;a<=10;a++) {
			for(int b=10;b>=0;b--) {
				System.out.println(a+" "+b);
			}
		}
		i=0;
		int j;
		while(i<=10) {
			j=10;
			while(j>=0) {
//				System.out.println(i+" "+j);
				j--;
			}
			i++;
		}
	}
}
