package com.user;
import com.vo.User;
import frame.Biz;

public class UserInsert {
	public static void main(String[] args) {		
		Biz<String, User> biz = new UserBiz();
		User u = new User("idABC", "pwd123", "Karim");
		try {
			//biz.register(u);
			//biz.register(u);
			//biz.remove("id0");
			//biz.modify(u);
			for(User k :biz.get()){
				System.out.println(k);
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
