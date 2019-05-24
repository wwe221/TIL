package ws;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	private UserId users[];
	private int lotto[];
	private float totalMoney = 0;
	private float earn;
	private static float suspended = 0;
	private int winner[][] = new int[3][100];
	int cnt[] = new int[3]; // 1,2,3등의 인원수를 배열에 저장

	public Lotto() {
	}

	public Lotto(UserId[] users) {
		this.users = users;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public float getSuspended() {
		return suspended;
	}

	public void setSuspended(float suspended) {
		this.suspended = suspended;
	}

	public UserId[] getUsers() {
		return users;
	}

	public float getEarn() {
		return earn;
	}

	@Override
	public String toString() {
		return "Lotto [users=" + Arrays.toString(users) + "]";
	}

	public void lotter() {
		int Lotto[] = new int[6]; // 컴퓨터가 뽑은 값 배열로 저장
		// 컴퓨터가 로또 당첨번호 생성 (1~20 중 6개)
		Random r = new Random();
		int com = 0;
		for (int i = 0; i < Lotto.length; i++) {
			com = r.nextInt(20) + 1;
			Lotto[i] = com;
			for (int j = 0; j < i; j++) {
				if (Lotto[j] != Lotto[i]) // 중복방지
				{
					Lotto[i] = com;
				} else {
					i--;
					break;
				}
			}
		}

		// 컴퓨터 생성번호 오름차순 정렬
		for (int i = 0; i < Lotto.length; i++) {
			for (int j = 0; j < Lotto.length - 1 - i; j++) {
				if (Lotto[j + 1] < Lotto[j]) {
					int temp = Lotto[j];
					Lotto[j] = Lotto[j + 1];
					Lotto[j + 1] = temp;
				}
			}
		}
		lotto = Lotto;

	}

	public void collectUser() {

		// 사용자가 선택한 번호와 베팅금액 정보 가져오기
		for (int k = 1; k < users.length; k++) {
			totalMoney += users[k].getBet();
			int usernumbers[] = new int[6];
			usernumbers = users[k].getNumbers();

			// 사용자의 숫자와 컴퓨터의 숫자 비교
			int count = 0;
			for (int i = 0; i < lotto.length; i++) {
				for (int j = 0; j < usernumbers.length; j++) {
					if (lotto[i] == usernumbers[j]) {
						count++;
					}
				}
			}

			// 동일한 숫자 6개 : 1등, 5개 : 2등, 4개 : 3등

			switch (count) {
			case 6:
				cnt[0]++;
				winner[0][cnt[0]] = k;

			case 5:
				cnt[1]++;
				winner[1][cnt[1]] = k;
			case 4:
				cnt[2]++;
				winner[2][cnt[2]] = k;
			}
		}

	}

	public int[] getLotto() {
		return lotto;
	}

	public void moneyCalc() { // 총금액 + 이월금액
		earn = totalMoney / 2; // 베팅금액의 50%는 회사의 이익금
		totalMoney /= 2; // 베팅금액의 나머지 50%로 당첨자에게 배분

		for (int i = 0; i < winner.length; i++) {
			for (int j = 0; j < winner[i].length; j++) {
				if (cnt[0] != 0) {
					users[winner[i][j]].setBenefit(totalMoney * (float) 0.65 / cnt[0]);
				} else {
					suspended += totalMoney * ((float) 0.65) / cnt[0];
				}

				if (cnt[1] != 0) {
					users[winner[i][j]].setBenefit(totalMoney * (float) 0.225 / cnt[1]);
				} else {
					suspended += totalMoney * (float) 0.225 / cnt[1];
				}

				if (cnt[2] != 0) {
					users[winner[i][j]].setBenefit(totalMoney * (float) 0.125 / cnt[2]);
				} else {
					suspended += totalMoney * (float) 0.125 / cnt[2];
				}
			}
		}
		totalMoney = 0;
	}

}
