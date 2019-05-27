package company;

public class Employee {
	protected String id;
	protected String name;
	protected double salary;
	protected String depy;

	public Employee() {

	}

	public Employee(String id, String name, double salary, String depy) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.depy = depy;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDepy(String depy) {
		this.depy = depy;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", depy=" + depy + "]";
	}

	public double salaryM() {
		double money = 0; // 4대 보험 8.4% , 세금 3.2%
		double tmp = 0;
		tmp += this.salary * 0.084;
		tmp += this.salary * 0.032;
		money = this.salary - tmp;
		return money;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDepy() {
		return depy;
	}
	public double annSalary() {
		double money =0;
		money = salaryM() * 12;
		return money;
	}

}
