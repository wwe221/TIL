package ws;

import java.util.HashMap;

public class UserDb extends Db<User, String, HashMap<String, User>> {

	@Override
	public void insert(User obj) {
		System.out.println(obj.getId() + " Inserted");
	}

	@Override
	public User select(String obj) {
		User p = null;
		System.out.print("Search: " + obj + "  ");
		p = new User("Lee", "id04", "pwd475");
		return p;
	}

	@Override
	public void delete(String obj) {
		String str = obj.toString();
		System.out.println(str + " is deleted");
	}

	@Override
	public HashMap<String, User> select() {
		HashMap<String, User> map = new HashMap<>();
		map.put("id01", new User("Kim", "id01", "pwd123"));
		map.put("id03", new User("Lee", "id03", "pwd654"));
		map.put("id04", new User("Park", "id04", "pwd987"));
		map.put("id02", new User("Choi", "id02", "pwd741"));
		map.put("id05", new User("Jang", "id05", "pwd852"));
		return map;
	}

	@Override
	public void Update(User obj) {
		String str = obj.toString();
		System.out.println(str + " is Updated");

	}

}
