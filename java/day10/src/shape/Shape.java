package shape;

public abstract class Shape {
	protected Point point;

	public Shape() {
	}

	public Shape(Point p) {
		this.point = p;
	}

	public Point getP() {
		return point;
	}

	public void setP(Point p) {
		this.point = p;
	}

	@Override
	public String toString() {
		return "Shape [p=" + point + "]";
	}

	public abstract double getArea();

	public abstract double getCircume();

	public void mov(int x, int y) {
		this.point.setX(x);
		this.point.setY(y);
	}

}
