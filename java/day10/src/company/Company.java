package company;

public class Company {

	public static void main(String[] args) {
		Employee e = new Employee("123", "kim", 1000, "Dev");		
		System.out.println(e);
		System.out.println(e.salaryM());
		System.out.println(e.annSalary());
		Manager m = new Manager("200", "Lee", 1000, "Dev", 100);
		
		System.out.println(m);
		System.out.println(m.salaryM());
		System.out.println(m.annSalary());

	}

}
