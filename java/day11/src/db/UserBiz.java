package db;

public class UserBiz extends Biz {
	Dao dao;

	public UserBiz(String ip) {
		dao = new UserDao(ip);
	}

	@Override
	public void register(Object obj) {
		
		//Transaction ends
		dao.insert(obj);
	}

	@Override
	public void remove(Object obj) {

		dao.delete(obj);

	}

	@Override
	public Object get(Object obj) {
		User u = (User)dao.select(obj);
		return u;
	}

}
