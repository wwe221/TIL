package com.sds.test;

import java.util.ArrayList;

import com.sds.component.UserBiz;
import com.sds.frame.Biz;
import com.sds.vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		ArrayList<User> list;
		try {
			list = biz.get();
			for(User tmp :list)
				System.out.println(tmp);
		} catch (Exception e) {
			System.out.println(" selectAll Error");
			System.out.println(e.getMessage());
			
		}

	}




}
