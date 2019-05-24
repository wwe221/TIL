package ws;

import java.util.Arrays;

public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a[] = new Account[10];
		a[0] = new Account("KIM");
		a[1] = new Account("LEE");
		a[2] = new Account("PARK");
		a[3] = new Account("JI");
		a[4] = new Account("SUNG");
		a[5] = new Account("SON");
		try {
			for (int i = 1; i < 7; i++) {
				a[i - 1].deposit(1000 * i);
			}
		} catch (Exception e) {
		}
		UserId user[] = new UserId[6];
		user[0] = new UserId(a[0], "kim", "1234");
		user[1] = new UserId(a[1], "lee", "5678");
		user[2] = new UserId(a[2], "park", "7777");
		user[3] = new UserId(a[3], "ji", "8888");
		user[4] = new UserId(a[4], "sung", "7428");
		user[5] = new UserId(a[5], "son", "7964");
		try {
			for (int i = 0; i < 6; i++) {
				user[i].setAcc(a[i]);
				user[i].lottery();
				user[i].charge(1000 * i);
				user[i].betting(1000);
			}
		} catch (Exception e) {
			if (e.getMessage().equals("E001"))
				System.out.println("돈이 없습니다");
		}
		Lotto lt = new Lotto(user);
		lt.lotter();
		System.out.println("당첨 번호");
		for (int i : lt.getLotto())
			System.out.print(i + " ");
		System.out.println();
		lt.collectUser();
		lt.moneyCalc();
		System.out.println();
		for (UserId i : lt.getUsers())
			System.out
					.println(i.getId() + " 의 이득은: " + i.getBenefit() + " 입니다. 뽑은 숫자" + Arrays.toString(i.getNumbers()));
		System.out.println("회사 수익금:" + lt.getEarn());
	}

}
