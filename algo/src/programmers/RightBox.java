package programmers;

import java.util.ArrayList;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/12909
public class RightBox {

	public static void main(String[] args) {
		String s = "(())()";
		System.out.println(solution("()()"));
		System.out.println(solution(s));
		System.out.println(solution("())("));
	}

	static boolean solution(String s) {
		boolean answer = true;
		char[] a = s.toCharArray();
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (!list.isEmpty()) {
				char tmp = list.get(list.size() - 1);
				if (tmp == '(' && a[i] == ')') {
					list.remove(list.size() - 1);
				} else
					list.add(a[i]);
			} else
				list.add(a[i]);
		}

		if (list.isEmpty())
			answer = true;
		else
			answer = false;
		
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push('(');
			} else {
				if(st.isEmpty())
					return false;
				st.pop();				
			}
		}
		if(st.isEmpty())
			return true;
		else
			return false;
	}
}
