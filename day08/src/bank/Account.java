package bank;

public class Account {
	private String onwer;
	private String accNum;
	private double balance;
	public static int cnt = 0; // 클라스 변수
	
	public Account() {
	}

	public Account(String onwer, String accNum, double balance) throws Exception {
		if (accNum.length() != 5) {
			throw new Exception("E1000");
		}
		this.onwer = onwer;
		this.accNum = accNum + cnt;
		this.balance = balance;
		cnt++;
	}

	public String getOnwer() {
		return onwer;
	}

	public String getAccNum() {
		return accNum;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [onwer=" + onwer + ", accNum=" + accNum + ", balance=" + balance + "]";
	}

	public void withdraw(double m) throws Exception {
		if (m <= 0) {
			throw new Exception("E0001");
		}
		if (this.balance < m) {
			throw new Exception("E0002");
		}
		this.balance -= m;

	}

	public void deposit(double m) throws Exception {
		if (m <= 0) {
			throw new Exception("E0001");
		}
		this.balance += m;
	}

}
