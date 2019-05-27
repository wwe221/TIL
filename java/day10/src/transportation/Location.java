package transportation;

public class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Location() {

	}

	
	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}

	
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

	public void setX(int x) {
		this.x = x;
	}

	
	public void setY(int y) {
		this.y = y;
	}
	

}
