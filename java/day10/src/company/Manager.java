package company;

public class Manager extends Employee {
	private double incentive;

	public Manager() {

	}

	public Manager(double incentive) {
		this.incentive = incentive;
	}

	public Manager(String id, String name, double salary, String depy, double incentive) {
		super(id, name, salary, depy); // 상위 클래스 인 Employee 의 Constructor 이용.
		this.incentive = incentive;
		this.salary += this.incentive;
	}
	// 재정의 Override

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", depy=" + depy + ", incentive="
				+ incentive + "]";
	}

	@Override
	public double salaryM() {
		double money = 0;
		money = super.salaryM() + this.incentive;
		return money;
	}

}
