package db;

public class App {

	public static void main(String[] args) {
		User user = new User("Kim", "i101", "pwd01");
		Biz b = new UserBiz("192.168.111.156");
		//b.register(user);
		//b.remove("i101");
		User gett = null;
		gett = (User)b.get("i101");
		System.out.println(gett);
		
	}

}
