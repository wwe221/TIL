package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game3 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int a, b;
		String str = "";
		int c=1;
		for (;c==1;c=sc.nextInt()) {
			System.out.println("1부터 6 까지의 숫자를 2개 입력하세요");
			a = sc.nextInt();
			b = sc.nextInt();
			if ((a > 6 || a < 0) || (b > 6 || b < 0)) {
				System.out.println("운세 뽑을 가치도 없으시군요");
				sc.close();
				return;
			}
			switch (Math.abs(a - b)) {
			case 0:
				str = "집에 갔는데 고기반찬이 차려져 있을 것이다.";
				break;
			case 1:
				str = "투자한 주식이 급등할 운세입니다.";
				break;
			case 2:
				str = "로또 5천원어치 샀는데 5천원 당첨될 운세입니다.";
				break;
			case 3:
				str = "집 가다가 벼락 맞을 운세입니다. 살아남으면 로또 하나 사세요";
				break;
			case 4:
				str = "출근길과 퇴근길, 지하철 연착할 운세입니다.";
				break;
			case 5:
				str = "편의점에서 우연히 산 삼각김밥이 1+1 행사 중일 운세입니다.";
				break;
			}			
			System.out.println(str);
			System.out.println("계속 하시려면 1을 입력하세요");
						
		}
		sc.close();
	}
}
