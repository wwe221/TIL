package db3;

public class UserDb extends Db<User, String> {
	@Override
	public void insert(User obj) {
		System.out.println(obj.getId()+" Inserted");		
	}
	@Override
	public User select(String obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
