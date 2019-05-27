package ws;

public class Account {

	private String Name;
	private float balance;

	{
		balance = 0;
	}

	public Account() {
	}

	public Account(String name, float balance) {
		Name = name;
		this.balance = balance;
	}

	public Account(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Account [Name=" + Name + ", balance=" + balance + "]";
	}

	public String getName() {
		return Name;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void withdraw(float money) throws Exception {
		if (money > this.balance) {
			throw new Exception("E1001");
		}
		this.balance -= money;

	}

	public void deposit(float money) {
		this.balance += money;
	}
}