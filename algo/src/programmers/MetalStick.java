package programmers;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42585
public class MetalStick {

	public static void main(String[] args) {
		String a = "()(((()())(())()))(())";
		System.out.println(solution(a));

	}

	static public int solution(String arrangement) {
		String str = arrangement.replace("()", "1");
		int answer = 0;
		ArrayList<Character> list = new ArrayList<>();
		ArrayList<Character> stack = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == '(') {
				stack.add(list.get(i));
			} else if (list.get(i) == '1') {
				answer += stack.size();
			} else if (list.get(i) == ')') {
				stack.remove(stack.size() - 1);
				answer += 1;
			}
		}
		return answer;
	}
}
