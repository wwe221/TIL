package baekzoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Socar1 {
	public static void main(String[] args) {
		String[][] friends = { { "david", "frank" }, { "demi", "david" }, { "frank", "james" }, { "demi", "james" },
				{ "claire", "frank" } };
		String user = "david";
		System.out.println(solution(friends, user));
	}

	private static String[] solution(String[][] friends, String user) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<>();
		
		int l = friends.length;
		int max = 0;
		for (int i = 0; i < l; i++) {
			map.put(friends[i][0], 0);
			map.put(friends[i][1], 0);
			if (friends[i][0].equals(user)) {
				list.add(friends[i][1]);
			} else if (friends[i][1].equals(user)) {
				list.add(friends[i][0]);
			}
		}
		map.remove(user);
		for (int i = 0; i < l; i++) {
			String a = friends[i][0];
			String b = friends[i][1];			
			if (!a.equals(user) || !b.equals(user)) {
				if (list.contains(a) && !b.equals(user)) {
					int tmp = map.get(b) + 1;
					if (tmp > max) {
						max = tmp;
						list2 = new ArrayList<String>();
						list2.add(b);
					} else if (tmp == max) {
						list2.add(b);
					}
					map.put(b, tmp);
				}
				if (list.contains(b) && !a.equals(user)) {
					int tmp = map.get(a) + 1;
					if (tmp > max) {
						max = tmp;
						list2 = new ArrayList<String>();
						list2.add(a);
					} else if (tmp == max) {
						list2.add(a);
					}
					map.put(a, tmp);
				}
			}
		}
		System.out.println(map.toString());
		return null;
	}

}
