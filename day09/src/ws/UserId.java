package ws;

import java.util.Arrays;
import java.util.Random;

public class UserId {
	// attribute
	private Account acc;
	private String id;
	private String passwod;
	private float benefit;
	private float bet;
	private int[] numbers;
	private float balance;
	private static int serial = 1000;

	// constructor
	public UserId() {

	}

	{
		this.numbers = new int[6];
		balance = 0;
		bet = 0;
		benefit = 0;
	}

	public UserId(Account acc, String id, String passwod) {
		this.acc = acc;
		this.id = id;
		this.passwod = passwod;
		this.serial = serial++;
	}

	public UserId(Account acc, String id, String passwod, float benefit, float bet, int[] numbers, float balance) {
		this.acc = acc;
		this.id = id;
		this.passwod = passwod;
		this.benefit = benefit;
		this.bet = bet;
		this.numbers = numbers;
		this.balance = balance;
	}

	public Account getAcc() {
		return acc;
	}

	public String getId() {
		return id;
	}

	public String getPasswod() {
		return passwod;
	}

	public void setBenefit(float benefit) {
		this.benefit = benefit;
	}

	public float getBenefit() {
		return benefit;
	}

	public float getBet() {
		return bet;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public float getBalance() {
		return balance;
	}

	public int getSerial() {
		return serial;
	}

	public void betting(float money) { //
		if (this.balance < money) {
			System.out.println("돈이 부족합니다");
			return;
		}
		this.balance -= money;
		this.bet = money;

	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public void lottery() {
		Random r = new Random();
		for (int ind = 0; ind < 6; ind++) { // 컴퓨터 숫자 생성(중복x)
			this.numbers[ind] = r.nextInt(20) + 1;
			for (int beforeInd = 0; beforeInd < ind; beforeInd++) {
				if (this.numbers[ind] == this.numbers[beforeInd]) {
					ind--;
				}
			}
		}
	}

	public void lottery(int numbers) {
		for (int ind = 0; ind < 6; ind++) {
			this.numbers[ind] = numbers;
			for (int beforeInd = 0; beforeInd < ind; beforeInd++) { // 중복방지
				if (this.numbers[ind] == this.numbers[beforeInd]) {
					System.out.println("중복된 숫자에요. 다시 입력해주세요");
					ind--;
				}
			}
		}
	}

	public void charge(float money) throws Exception {
		float tmp = acc.getBalance();
		if (tmp < money) {
			throw new Exception("E001");
		}
		acc.setBalance(tmp - money);
		this.balance += money;
	}

	@Override
	public String toString() {
		return "UserId [acc=" + acc + ", id=" + id + ", passwod=" + passwod + ", benefit=" + benefit + ", bet=" + bet
				+ ", numbers=" + Arrays.toString(numbers) + ", balance=" + balance + "]";
	}

}