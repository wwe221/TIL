package transportation;

public class Bus extends Transportation {
	private String busType;
	private int busNumb;
	{
		this.setFare(1250);
	}

	public Bus(Location boradPoint, Location getoffPoint, String busType, int busNumb) {
		super(boradPoint, getoffPoint);

		this.busType = busType;
		this.busNumb = busNumb;
	}

	@Override
	public String toString() {
		return "Bus [toString()=" + super.toString() + ", busType=" + busType + ", busNumb=" + busNumb + "]";
	}

	public Bus(Location boradPoint, Location getoffPoint) {
		super(boradPoint, getoffPoint);
	}

	@Override
	public double fareCalc() {
		double x1 = this.getBoardPoint().getX();
		double y1 = this.getBoardPoint().getY();
		double x2 = this.getGetoffPoint().getX();
		double y2 = this.getGetoffPoint().getY();
		double a = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		double f = 0;
		if (a <= 10) {
			f += this.getFare();
		} else {
			while (a > 10) {
				f += this.getFare() + 100;
				a -= 5;
			}
		}

		return f;
	}

}
