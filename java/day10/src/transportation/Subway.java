package transportation;

public class Subway extends Transportation {

	private String line;
	{
		this.setFare(1250);
	}

	public Subway() {
	}

	public Subway(String line) {
		this.line = line;
	}

	public Subway(Location boardPoint, Location getoffPoint, String line) {
		super(boardPoint, getoffPoint);
		this.line = line;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public double fareCalc() {

		double x1 = this.getBoardPoint().getX();
		double y1 = this.getBoardPoint().getY();
		double x2 = this.getGetoffPoint().getX();
		double y2 = this.getGetoffPoint().getY();
		double distance = Math.sqrt(Math.pow(x1 - x2, 2)+Math.pow(y1-y2, 2));
		double fare = this.getFare();

		while (distance >= 10) {
			distance -= 10;
			fare += 200;
		}
		return fare;
	}

	@Override
	public String toString() {
		return "Subway [line=" + line + ", toString()=" + super.toString() + "]";
	}

}
