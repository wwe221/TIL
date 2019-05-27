package shape;

public class Rectangle extends Shape {

	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point point, int width, int height) {
		super(point);
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return (this.width * this.height);
	}

	@Override
	public double getCircume() {
		return 2 * this.width + 2 * this.height;
	}

	@Override
	public String toString() {
		return "Rectangle [point=" + point + ", width=" + width + ", height=" + height + "]";
	}

}
