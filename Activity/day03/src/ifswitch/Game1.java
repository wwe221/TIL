package ifswitch;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
		// 1~3 말고는 안녕 출력
		System.out.println("1:가위 ,2:바위 ,3:보");
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int c = random.nextInt(3) + 1;
		int u = sc.nextInt();
		if (u != 1 && u != 2 && u != 3) {
			System.out.println("안녕!~");
			return;
		}
		String str = "";
		String[] K = { "가위", "바위", "보" };
		System.out.println("당신은 " + K[u - 1] + " 냈습니다");
		System.out.println("컴퓨터는 " + K[c - 1] + " 냈습니다");
		// 1: 가위, 2: 바위, 3: 보
		switch (u - c) {
		case -1:// u = 가위&& c =바위 || u=바위&& c=보
		case 2:
			str = "졌습니다";
			break;
		case -2:
		case 1:
			str = "이겼습니다";
			break;
		case 0:
			str = "비겼습니다";
			break;
		}
		System.out.println(str);
	}

}
