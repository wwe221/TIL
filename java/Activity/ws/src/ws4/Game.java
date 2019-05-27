package ws4;

//브루마블2
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
//4.각 플레이어가 주사위를 한번씩 던져 나온 숫자만큼 이동
//5.해당 위치에 있는 숫자만큼 포인트 차감
//6.계속해서 진행한 후 포인트가 0이하가 된 플레이어 패배
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int[][] map = new int[8][8];
		int[][] prop = new int[8][8];
		int p1 = 1000, p2 = 1000;
		boolean t = true;
		int[] p1s = { 0, 0 };
		int[] p2s = { 0, 0 };
		int c = 0;
		int i = 0;
		int j = 0;
		int cnt = 0;
		int r;
		// 테두리에만 통행료를 가진 배열 생성
		for (i = 0; i < map.length - 1; i++) {
			r = ran.nextInt(100) + 1;
			map[i][j] = r;
		}
		for (i = 0; i < map.length - 1; i++) {
			r = ran.nextInt(100) + 1;
			map[j][i] = r;
		}
		for (j = 7; i >= 0; i--) {
			r = ran.nextInt(100) + 1;
			map[j][i] = r;
		}
		for (i = 0; i < map.length - 1; i++) {
			r = ran.nextInt(100) + 1;
			map[i][j] = r;
		}
		for (i = 0; i < map.length; i++) {
			for (j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		String str;
		int in;
		while (true) {
			if (t) {
				System.out.println("다음턴을 진행하시려면 아무키나 입력하세요");
				str = sc.next();
				System.out.println("Player1's turn");
				System.out.printf("현재위치: %d,%d 나온 주사위: ", p1s[0], p1s[1]);
				r = ran.nextInt(6) + 1;
				System.out.println(r);
				p1s = move2(p1s, r);
				System.out.printf("움직인 위치: %d,%d ", p1s[0], p1s[1]);
				if (prop[p1s[0]][p1s[1]] == 0) {
					System.out.println("남은 돈: " + p1);
					System.out.println("빈땅입니다 구매하시겠습니까? 1: 예 /2: 아니오");
					System.out.println("가격: " + map[p1s[0]][p1s[1]]);
					in = sc.nextInt();					
					if (in == 1) {
						System.out.println("구매했씁니다.");	
						prop[p1s[0]][p1s[1]] = 1;
						p1 -= map[p1s[0]][p1s[1]];
					}
				} else if (prop[p1s[0]][p1s[1]] == 2) {
					System.out.println("상대방의 소유지입니다");
					System.out.println("가격: " + map[p1s[0]][p1s[1]]);
					System.out.println("통행료: " + map[p1s[0]][p1s[1]] * 2 + "원 지불했습니다.");
					p1 -= map[p1s[0]][p1s[1]] * 2;
				}
				System.out.println("남은 돈: " + p1);
				t = false;
			} else {
				System.out.println("다음턴을 진행하시려면 아무키나 입력하세요");
				str = sc.next();
				System.out.println("Player2's turn");
				System.out.printf("현재위치: %d,%d 나온 주사위: ", p2s[0], p2s[1]);
				r = ran.nextInt(6) + 1;
				System.out.println(r);
				p2s = move2(p2s, r);
				System.out.printf("움직인 위치: %d,%d ", p2s[0], p2s[1]);
				if (prop[p2s[0]][p2s[1]] == 0) {
					System.out.println("남은 돈: " + p2);
					System.out.println("빈땅입니다 구매하시겠습니까? 1: 예 /2: 아니오");
					System.out.println("가격: " + map[p2s[0]][p2s[1]]);
					in = sc.nextInt();
					if (in == 1) {
						System.out.println("구매했씁니다.");	
						prop[p2s[0]][p2s[1]] = 2;
						p2 -= map[p2s[0]][p2s[1]];
					}
				} else if (prop[p2s[0]][p2s[1]] == 1) {
					System.out.println("상대방의 소유지입니다");
					System.out.println("가격: " + map[p2s[0]][p2s[1]]);
					System.out.println("통행료: " + map[p2s[0]][p2s[1]] * 2 + "원 지불했습니다.");
					p2 -= map[p2s[0]][p2s[1]] * 2;
				}
				System.out.println("남은 돈: " + p2);
				t = true;
			}
			System.out.println();
			cnt++;
			if (p1 <= 0) {
				System.out.println("Player2's win");
				break;
			}
			if (p2 <= 0) {
				System.out.println("Player1's win");
				break;
			}
		} // end while

	}

	static int[] move2(int[] a, int b) {
		int[] res = a;
		int c;
		if (res[0] == 0 && res[1] != 7) // 오른쪽으로
			res[1] += b;
		else if (res[0] != 7 && res[1] == 7) // 아래로
			res[0] += b;
		else if (res[0] == 7 && res[1] != 0) // 왼쪽으로
			res[1] -= b;
		else if (res[0] != 0 && res[1] == 0) // 위쪽으로
			res[0] -= b;

		if (res[0] == 0 && res[1] > 7) { // 오른쪽 오버
			c = res[1] - 7; // 넘친만큼
			res[0] += c; // 아래로 더하고
			res[1] = 7; // 제자리로
		}
		if (res[0] > 7 && res[1] == 7) {
			c = res[0] - 7;
			res[1] -= c;
			res[0] = 7;
		}
		if (res[0] == 7 && res[1] < 0) {
			c = 0 - res[1];
			res[0] -= c;
			res[1] = 0;
		}
		if (res[0] < 0 && res[1] == 0) {
			c = 0 - res[0];
			res[1] += c;
			res[0] = 0;
		}
		return res;

	}

}
