import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ser.User;

public class Main2 {

	public static void main(String[] args) throws Exception {
		FileInputStream fos = new FileInputStream("user.dat");
		BufferedInputStream bos = new BufferedInputStream(fos);
		ObjectInputStream oop = new ObjectInputStream(bos);
		
		User u = (User) oop.readObject();
		System.out.println(u);
		oop.close();
	}

}
