package ws2;

public class MobileTest {

	public static void main(String[] args) {
		Mobile m[] = new Mobile[2];
		m[0] = new Ltab("Ltab", 500, "AP-01");
		m[1] = new Otab("Otab", 1000, "AND-20");
		System.out.println("\nMobile\tBattery\tOS\n--------------------------------------------------------");
		for (Mobile tmp : m) {
			System.out.println(tmp.toString());
		}
		System.out.println("\nMobile\tBattery\tOS\n--------------------------------------------------------");
		for (Mobile tmp : m) {
			tmp.charge(10);
			System.out.println(tmp.toString());
		}
		System.out.println("\nMobile\tBattery\tOS\n--------------------------------------------------------");
		for (Mobile tmp : m) {
			tmp.operate(5);
			System.out.println(tmp.toString());
		}

	}
}
