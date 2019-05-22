package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game4 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int c, u, cnt = 0, cnt2 = 0;
		String in;
		String str , str2;
		while (true) {
			System.out.println("1:가위 ,2:바위 ,3:보");
			c = random.nextInt(3) + 1;
			in = sc.next();
			if (in.equals("q")) {
				System.out.println("종료");
				break;
			}
			u = Integer.parseInt(in);
			if (u != 1 && u != 2 && u != 3) {
				System.out.println("1부터 3까지 입력하세요");
				continue;
			}
			str = "";
			if(u==1)
				str2="가위";
			else if(u==2)
				str2="바위";
			else
				str2="보";
			System.out.print(str2+"vs");
			if(c==1)
				str2="가위";
			else if(c==2)
				str2="바위";
			else
				str2="보";
			System.out.println(str2);
			cnt2++;
			switch (u - c) {
			case -1:// u = 가위&& c =바위 || u=바위&& c=보
			case 2:
				str = "패배";
				break;
			case -2:
			case 1:
				str = "승리!";
				cnt++;
				break;
			case 0:
				str = "무승부";
				break;
			}
			System.out.println(str);
			System.out.println("총 게임 횟수:" + cnt2 + " 이긴 횟수: " + cnt);
			System.out.println("다른 수를 내세요\n");
		}
		
	}
}
