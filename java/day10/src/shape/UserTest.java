package shape;

public class UserTest {
	public static void main(String[] args) {
		User u = new User();
		System.out.println(u.draw(new Circle(new Point(1, 1), 3)));
	}

}
