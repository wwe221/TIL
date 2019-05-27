package transportation;

public class Train extends Transportation {
	private String line;
	{
		this.setFare(3000);
	}

	public Train(Location boardPoint, String line) {
		super(boardPoint);
		this.line = line;
	}

	public Train(Location boradPoint, Location getoffPoint, String line) {
		super(boradPoint, getoffPoint);
		this.line = line;
	}

	public Train(String line) {
		this.line = line;
	}

	public Train() {

	}

	@Override
	public String toString() {
		return "Train [toString()=" + super.toString() + ", line=" + line + "]";
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public double fareCalc() {
		double x1 = this.getBoardPoint().getX();
		double y1 = this.getBoardPoint().getY();
		double x2 = this.getGetoffPoint().getX();
		double y2 = this.getGetoffPoint().getY();
		double a = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		double f = 0;
		if (a <= 20) {
			f += this.getFare();
		} else {
			while (a > 10) {
				f += this.getFare() + 1000;
				a -= 10;
			}
		}
		return f;
	}

}
