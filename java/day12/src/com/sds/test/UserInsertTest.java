package com.sds.test;

import com.sds.component.UserBiz;
import com.sds.frame.Biz;
import com.sds.vo.User;

public class UserInsertTest {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		User u1 = new User("Tom", "id01", "pwd0230");
		try {
			biz.register(u1);
		} catch (Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
			
		}

	}

}
