package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserInsert {
	public static void main(String[] args) {		
		Biz<String, User> biz = new UserBiz();
		try {
			//biz.register(u);
			//biz.register(u);
			//biz.remove("id69");
			//biz.modify(u2);
			for(User k :biz.get()){
				System.out.println(k);
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
