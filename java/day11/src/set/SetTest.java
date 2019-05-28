package set;

import java.util.HashSet;
import java.util.Random;

public class SetTest {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		Random ran = new Random();
		while (true) {
			set.add(ran.nextInt(45) + 1);
			if (set.size() >= 6)
				break;
		}
		System.out.println(set.toString());
		Object[] a = new Integer[set.size()];
		a = set.toArray();
		for (Object tmp : a)
			System.out.println(tmp);

	}

}
