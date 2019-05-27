package shape;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public Point() {

	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
