package bank;

public class Account {
	private int balance;
	public Account() {
		
	}
	public Account(int balance) {
		this.balance = balance;
	}
	public void deposit(int m) throws Exception{
		if(m <=0) {
			throw new Exception();
		}
		balance += m;
		notify();
	}
	public synchronized void widthdraw(int m) throws Exception{		
		if(balance>= m)
			balance -=m;
		else
			wait();
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
