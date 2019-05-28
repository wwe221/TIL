package set;

import java.util.ArrayList;
import java.util.Stack;

public class ListTest2 {

	public static void main(String[] args) {
		Stack a = new Stack<Integer>();
		
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("Name", "id01", "pwd123"));
		list.add(new User("Kim", "id02", "pwd333"));
		list.add(new User("Lee", "id03", "pwd121"));
		list.add(new User("Park", "id04", "pwd456"));
		list.add(new User("Jung", "id05", "pwd789"));
		list.add(new User("Im", "id06", "pwd654"));
		System.out.println(list.size());
		list.remove(2);
		for(User tmp : list)
			System.out.println(tmp);
	}

}
