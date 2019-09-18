package bank;

class header extends Thread {
	Account acc;	
	public header(Account acc) {
		this.acc = acc;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(80);
				int m = (int) (Math.random() * 3 + 1) * 100;
				acc.deposit(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Branch extends Thread {
	Account acc;
	String name;

	public Branch() {

	}

	public Branch(Account acc, String name) {
		this.acc = acc;
		this.name = name;
	}

	@Override
	public void run() {
			int m = 500;
			try {
				acc.widthdraw(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(name + " " + acc.getBalance());
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}
}

public class Bank {
	public static void main(String[] args) {
		Account acc = new Account(700);
		header h = new header(acc);
		h.start();
		Branch b1 = new Branch(acc, "b1");
		Branch b2 = new Branch(acc, "b2");
		Branch b3 = new Branch(acc, "b3");
		Branch b4 = new Branch(acc, "b4");
		b1.start();
		b2.start();
		b3.start();
		b4.start();
	}
}
