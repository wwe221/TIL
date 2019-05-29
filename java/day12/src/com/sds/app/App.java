package com.sds.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.sds.component.UserBiz;
import com.sds.frame.Biz;
import com.sds.vo.User;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = "";
		wL: while (true) {
			System.out.println("MENU : r, g , q");
			in = sc.next();
			Biz<String,User> b = new UserBiz();
			switch (in) {
			case "r":
				System.out.println("Input User Date (name , id , pwd)");
				String name = sc.next();
				String id = sc.next();
				String pwd = sc.next();
				User u = new User(name, id, pwd);				
				try {
					b.register(u);
				} catch (Exception e) {
					System.out.println("register Error");
					System.out.println(e.getMessage());					
				}
				break;
			case "g":
				try {
					ArrayList<User> list=b.get();
					for(User tmp : list)
						System.out.println(tmp);
				} catch (Exception e) {
					System.out.println("get Error");
					System.out.println(e.getMessage());	
				}
				break;

			case "q":
				System.out.println("PEACE OUT");
				break wL;
			}

		}
		sc.close();
	}

}
