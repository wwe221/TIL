package test;

import java.util.ArrayList;
import java.util.Scanner;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserInsert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cin = 0;
		Dao<String, User> dao = new UserDao();
		ArrayList<User> in = new ArrayList<User>();
		User u = null;
		String k = "";
		System.out.println("INSERT : 1, DELETE : 2, UPDATE : 3 , SELECT : 4 , SELECTALL : 5");
		cin = sc.nextInt();
		String id, pwd, name;
		try {
			switch (cin) {
			case 1:
				System.out.println("putin ID, PWd , Name");
				id = sc.next();
				pwd = sc.next();
				name = sc.next();
				u = new User(id, pwd, name);
				dao.insert(u);
				break;
			case 2:
				System.out.println("putin ID");
				k = sc.next();
				dao.delete(k);
				break;
			case 3:
				System.out.println("putin ID, PWd , Name");
				id = sc.next();
				pwd = sc.next();
				name = sc.next();
				u = new User(id, pwd, name);
				dao.update(u);
				break;
			case 4:
				System.out.println("putin ID");
				k = sc.next();
				u = dao.select(k);
				System.out.println(u.toString());
				break;
			case 5:
				in = dao.select();
				for (User tmp : in)
					System.out.println(tmp.toString());
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
