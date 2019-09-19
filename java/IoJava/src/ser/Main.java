package ser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("user.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oop = new ObjectOutputStream(bos);
		User u = new User("id01", "pwd01", 30);
		oop.writeObject(u);
		oop.close();		
	}

}
