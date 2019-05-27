package car;

public class CarTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car cars[] = new Car[3];
		cars[0] = new Car("K2", "Black", 50, 70);
		cars[1] = new Car("K3", "Yellow", 70, 100);
		cars[2] = new Car("K4", "Red", 90, 120);
		for (Car tmp : cars) {
			try {
				tmp.setCfSize(70);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(tmp.getName() + "'s fuel is gettin Too much");
			}
			System.out.println(tmp);
		}
	}

}
