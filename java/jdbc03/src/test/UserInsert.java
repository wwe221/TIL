package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserInsert {

	public static void main(String[] args) {
		User u = new User("id69","pwd77", "±è±â»ç");
		User u2 = new User("id69","pwd99", "±èÃÑ¹«");
		Biz<String, User> biz = new UserBiz();
		try {
			biz.register(u);
			biz.remove("id68");
			biz.modify(u2);
			for(User k :biz.get()){
				System.out.println(k);
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
