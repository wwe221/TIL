package shape;

public class Triangle extends Shape {
	private int width;
	private int height;

	public Triangle() {
	}

	public Triangle(Point point, int width, int height) {
		super(point);
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Triangle [point=" + point + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public double getArea() {
		return (this.width * this.height) / 2;
	}

	@Override
	public double getCircume() {
		double a = Math.pow(this.width, 2);
		double b = Math.pow(this.height, 2);
		double c = Math.sqrt(a + b);
		return c + this.height + this.width;
	}

}
