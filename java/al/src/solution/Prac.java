package solution;

import java.util.*;

public class Prac {
	public static void main(String[] args) {
		String name = "JEROEN";
		System.out.println(solution(name));
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
		fromz = 'Z' - n[0] + 1;
		toa = n[0] - 'A';
		tmp = fromz < toa ? toa : fromz;
		cnt += tmp;
		cnt++;
		cnt2 += tmp;
		cnt2++;
		

		return answer;
	}
}
