package shape;

public class User {
	String id;
	public User() {
		id = "Lee";
	}
	public String draw ( Shape shape) {
		String str ="";
		str = shape.toString();
		return str;
	}
}
