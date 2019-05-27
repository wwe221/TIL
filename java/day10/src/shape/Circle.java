package shape;

public class Circle extends Shape {
	private int radius;
	private String color;

	public Circle() {
	}

	public Circle(Point point, int radius) {
		super(point);
		this.radius = radius;
	}

	public Circle(Point p, int radius, String color) {
		super(p);
		this.radius = radius;
		this.color = color;
	}

	@Override
	public double getArea() {
		double pi = Math.PI;
		return pi * Math.pow(this.radius, 2);
	}

	@Override
	public double getCircume() {
		double pi = Math.PI;
		return 2 * pi * this.radius;
	}

	public void fillColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Circle [point=" + point + ", radius=" + radius + ", color=" + color + "]";
	}

}
