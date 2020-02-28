package mlCT;

import java.util.ArrayList;

public class N2 {

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "ABCD";
		System.out.println(solution(s1, s2));
	}

	public static String solution(String s1, String s2) {
		String answer = "";
		ArrayList<String> list = new ArrayList<>();
		int l1 = s1.length();
		int l2 = s2.length();
		System.out.println(s1+" "+s2 +"===");
		int max = 0;
		int l;
		if (l2 > l1) {
			l = l1;
		} else {
			l = l2;
			l = l2;
			l2= l1;
			l1 = l;
			String s3 = s2;
			s2 = s1;
			s1 = s3;
		}
		// s1 Ã³À½ : s2 ³¡
		for (int i = 0; i < l; i++) {
			String tmp1 = s1.substring(0, i);
			String tmp2 = s2.substring(l2 - i, l2);
			System.out.println(tmp1+" "+tmp2);
			if (tmp1.equals(tmp2)) {
				if (tmp1.length() > max) {
					max = tmp1.length();
					list = new ArrayList<>();
					String tmp = s2 + s1.substring(i);
					System.out.println(tmp + "---------1");
					list.add(tmp);
				} else if (tmp1.length() == max) {
					String tmp = s1 + s2.substring(i);
					System.out.println(tmp + "____");
					list.add(tmp);
				}
			}
		}
		System.out.println("@@@@@@@@@");
		for (int i = 1; i < l; i++) {
			String tmp2 = s1.substring(l - i, l);
			String tmp1 = s2.substring(0, i);
			System.out.println(tmp1+" "+tmp2);
			if (tmp1.equals(tmp2)) {
				if (tmp1.length() > max) {
					max = tmp1.length();
					list = new ArrayList<>();
					String tmp = s1 + s2.substring(i);
					System.out.println(tmp + "____");
					list.add(tmp);
				} else if (tmp1.length() == max) {
					String tmp = s1 + s2.substring(i);
					System.out.println(tmp + "--------2");
					list.add(tmp);
				}
			}
		}
		answer = list.remove(0);
		if (!list.isEmpty()) {
			String a = list.remove(0);
			System.out.println(answer +" :cmp: "+a);
			if (answer.compareTo(a) >0) {
				answer = a;
			}
		}
		System.out.println();
		return answer;
	}

}
