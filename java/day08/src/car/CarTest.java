package car;

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		System.out.println(car1);
		try {
			car1.setCfSize(60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e.getMessage().equals("1")){
				System.out.println("someting");
				e.printStackTrace();
			} else
				System.out.println("Too Much");
		}
		System.out.println(car1);
		car1.go(4);
		System.out.println(car1);

	}

}
