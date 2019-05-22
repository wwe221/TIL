package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int[] j = new int[11]; //뽑은 숫자 중복 체크를 위한 배열
		int[] mynumb = new int[6]; // 내가 뽑은 숫자
		int[] Lnumb = new int[6]; //당첨 번호
		int in;
		int r;
		int cnt = 0;
		for (int i = 0; i < 6; i++) { // 6개의 번호를 입력받고 만약 이미 뽑은 수(J[in]==1) 라면 다시 입력 받는다.
			while (true) {
				in = sc.nextInt();
				if (j[in] == 0) {
					j[in] = 1;
					mynumb[i] = in;
					break;
				} else if (j[in] == 1) {
					System.out.println("중복된 숫자가 있습니다");
					continue;
				}
			}
		}
		j = new int[11]; //뽑은 수 저장 배열 초기화
		for (int i = 0; i < 6; i++) {
			while (true) {
				r = ran.nextInt(9) + 1;
				if (j[r] == 0) {
					j[r] = 1;
					Lnumb[i] = r;
					break;
				} else if (j[r] == 1)
					continue;
			}
		}
		Arrays.sort(mynumb); 
		Arrays.sort(Lnumb); // 보기 좋게 뽑은 번호와 당첨번호 정렬
		System.out.println("내 번호\t" + Arrays.toString(mynumb));
		System.out.println("당첨 번호\t" + Arrays.toString(Lnumb));
		for (int i : mynumb)
			for (int k : Lnumb)
				if (k == i)
					cnt++;
		long per;
		switch (cnt) { // 일치하는 번호의 수 만큼 per를 나눠 당첨금을 계산한다.
		case 3:
			per = 20;
			System.out.println("등수: 4");
			break;
		case 4:
			per = 10;
			System.out.println("등수: 3");
			break;
		case 5:
			per = 5;
			System.out.println("등수: 2");
			break;
		case 6:
			per = 2;
			System.out.println("등수: 1");
			break;
		default:
			per = 0;
			System.out.println("등수: 꽝");
			break;
		}
		long lott = 0;
		for (int i = 0; i < 10; i++) { 
			// 당첨금 생성, Random.nextInt()의 범위를 최댓값을 맞추기 위해 0~10억 까지 하고, 최소값을 맞추기 위해 1억을 더했다.
			// 총 10번 실행하여 범위를 맞춘다.
			lott += (long) (ran.nextInt(1000000000) + 100000000);
		}
		//자릿수를 표시하기위해 배열에 넣고 배열의 길이를 통해 
		//몇자리수 인지 알아내고 계산하여 자릿수를 표시한다.
		long[] some = new long[1];
		some[0] = lott;
		long meGet = (long) (lott / per);
		String out = Arrays.toString(some);
		String out2 = "";
		int len = out.length() - 2; // 총 몇자리수인가
		int cnt2 = len % 3; //3으로 나눈 나머지의 자릿수들을 먼저 저장
		for (int i = 1; i <= cnt2; i++) {
			out2 += out.charAt(i);
		}
		for (int i = cnt2 + 1; i <= len; i += 3) { //3자리마다 쉼표를 추가한다.
			out2 += "," + out.charAt(i) + out.charAt(i + 1) + out.charAt(i + 2);
		}
		if (cnt2 == 0)
			out2 = out2.substring(1, out.length() + 1);  // 만약 자릿수가 3으로 나누어 떨어진다면 ,제일 앞 쉼표 하나를 지운다
		System.out.println("총 당첨금: " + out2);
		
		//위와 같다
		some[0] = meGet;
		out = Arrays.toString(some);
		out2 = "";
		len = out.length() - 2;
		cnt2 = len % 3;
		for (int i = 1; i <= cnt2; i++) {
			out2 += out.charAt(i);
		}
		for (int i = cnt2 + 1; i <= len; i += 3) {

			out2 += "," + out.charAt(i) + out.charAt(i + 1) + out.charAt(i + 2);
		}
		if (cnt2 == 0)
			out2 = out2.substring(1, out.length() + 1);
		System.out.println("내 당첨금: " + out2);

	}
}
