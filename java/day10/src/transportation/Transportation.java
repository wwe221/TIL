package transportation;

public abstract class Transportation {
	private double fare;
	private Location boardPoint;
	private Location getoffPoint;

	public Transportation(Location boardPoint) {
		super();
		this.boardPoint = boardPoint;
	}

	public Transportation(Location boradPoint, Location getoffPoint) {
		this.boardPoint = boradPoint;
		this.getoffPoint = getoffPoint;
	}

	public Transportation() {

	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public void setBoardPoint(Location boradPoint) {
		this.boardPoint = boradPoint;
	}

	public void setGetoffPoint(Location getoffPoint) {
		this.getoffPoint = getoffPoint;
	}

	public abstract double fareCalc();

	@Override
	public String toString() {
		return "Transportation [fare=" + fare + ", boradPoint=" + boardPoint + ", getoffPoint=" + getoffPoint + "]";
	}

	public double getFare() {
		return fare;
	}

	public Location getBoardPoint() {
		return boardPoint;
	}

	public Location getGetoffPoint() {
		return getoffPoint;
	}

}
