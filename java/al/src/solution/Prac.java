package solution;

import java.util.*;

public class Prac {
	public static void main(String[] args) {
		String name = "JAZ";
		solution(name);
	}

	public static int solution(String name) {
		int answer = 0;
		int l = name.length();
		char[] n = new char[l];
		n = name.toCharArray();
		// i 번째 자리의 글자를 가져와서 Z에서 빼는게 빠른지 A에서 가는게 빠른지 구하고 더 빠른 만큼 값을 더한다.
		int fromz = 0;
		int toa = 0;
		int cnt = 0; // 오른쪽으로 움직일때
		int cnt2 = 0; // 왼쪽으로 움직일때
		int tmp = 0;
		// 제일 첫 글자는 커서를 움직이기 전에 계산.
		fromz = 'Z' - n[0] + 1;
		toa = n[0] - 'A';
		tmp = fromz < toa ? fromz : toa;
		cnt += tmp;
		cnt2 += tmp;
		// ++ 로 다음 글자로 이동. 해당 글자에서 어느게 더 빠른지 계산하고 cnt에 더한뒤에 다음글자로 이동.
		for (int i = 1, j = l - 1; i < l; i++, j--) {
			{ // 오른쪽으로 갈때
				cnt++;
				fromz = 'Z' - n[i] + 1;
				toa = n[i] - 'A';
				tmp = fromz < toa ? fromz : toa;
				cnt += tmp;
			}
			{// 왼쪽으로 갈때
				cnt2++;
				fromz = 'Z' - n[j] + 1;
				toa = n[j] - 'A';
				tmp = fromz < toa ? fromz : toa;
				cnt2 += tmp;
				System.out.println(n[j] + " " + cnt2);
			}
			// 마지막으로 접근하는 녀석이 A 면 칸을 넘기지 않고 끝낸다.
			
			
		}
		System.out.println();
		System.out.println();
		System.out.println(cnt);
		System.out.println(cnt2);

		return answer;
	}
}
