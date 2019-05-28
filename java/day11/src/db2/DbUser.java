package db2;

public class DbUser extends DB {
	public DbUser(String ip) {
		super(ip);
	}

	@Override
	public void insert(Object obj) {
		//
		connection();
		System.out.println(((User) obj).getName()+" Inserted..");
		close();

	}

	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		User u = null;
		String str = (String)obj;
		connection();
		u = new User("newName", "newId", "newPwd");
		close();
		return u;
	}

}
