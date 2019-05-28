package db;

public class UserDao extends Dao {

	public UserDao() {

	}

	public UserDao(String ip) {
		super(ip);
	}

	@Override
	public void insert(Object obj) {
		connection();
		User u = (User) obj;
		System.out.println(u.getName());
		close();

	}

	@Override
	public Object select(Object obj) {
		User u = null;
		String str = (String) obj;
		connection();
		u = new User("id01", "Tim", "pw101");

		close();
		return u;
	}

	@Override
	public void delete(Object obj) {
		String str = (String) obj;
		connection();
		System.out.println(str + " is deleted");
		close();

	}

}
