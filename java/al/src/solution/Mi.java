package solution;

public class Mi {
	public static void main(String[] args) {
		String s = "falsefalsefalse";
		String t = "falsefalsefalsefalsefalsefalsefalsefalse";
		System.out.println(solution(s, t));
		System.out.println(solution2(s, t));

	}

	public static boolean solution(String s, String t) {
		boolean answer = true;

		int sl = s.length();
		int tl = t.length();

		String a; // 길이가 짧은 것 넣기
		String b;

		int minl = sl > tl ? tl : sl; // 둘 중 작은 길이
		int maxl = sl > tl ? sl : tl;

		if (sl == tl)// 두개의 길이가 같으면
			return answer = s.equals(t);

		if (minl == sl) {
			a = s;
			b = t;

		} else {
			a = t;
			b = s;
		}

		boolean flag = false;

		for (int i = 0; i < minl; i++) {
			if (!(b.charAt(0) == a.charAt(i))) {
				flag = true; // 다른게 하나라도 있으면
				answer = false;
				break;
			}
		}

		if (!flag) {// 다른게 없다면
			for (int i = 1; i < maxl; i++) {
				if (!(b.charAt(0) == b.charAt(i))) {
					answer = false;
					break;
				}
			}
		}

		if (maxl % minl == 0) { // 길이가 나누어 떨어진다면,
			// 큰거 안에서 작은것이 계속 반속되어 들어가는지 체크
			for (int i = 0; i < maxl; i += minl) {
				System.out.println(i + minl);
				if (!(b.substring(i, i + minl).equals(a))) {
					answer = false;
					break;
				}
			}
		} else {
			int ll = maxl % minl;
			for (int i = 0; i < minl; i += ll) {
				System.out.println(b.substring(maxl - ll, maxl));
				if (!(a.substring(i, i + ll).equals(b.substring(maxl - ll, maxl)))) {
					answer = false;
					break;
				}
			}

		}
		return answer;
	}

	public static boolean solution2(String s, String t) {
		boolean answer = true;
		int sl = s.length();
		int tl = t.length();
		String a; // 길이가 짧은 것 넣기
		String b;
		int minl = sl > tl ? tl : sl; // 둘 중 작은 길이
		int maxl = sl > tl ? sl : tl;
		if (sl == tl)// 두개의 길이가 같으면
			return s.equals(t);
		if (minl == sl) {
			a = s;
			b = t;
		} else {
			a = t;
			b = s;
		}
		int n = 0;
		String bb = "";
		for (int i = 1; i <= minl * maxl; i++) {
			bb += b;
			if (maxl * i % minl == 0) {
				n = maxl * i;
				break;
			}
		}
		System.out.println(n);
		String aa = "";
		for (int i = 0; i < n / minl; i++) {
			aa += a;
		}
		System.out.println(bb);
		System.out.println(aa);
		if (bb.equals(aa))
			answer = true;
		else
			answer = false;

		return answer;
	}
}
