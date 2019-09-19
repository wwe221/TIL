import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Fi2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		fi = new FileInputStream("\\\\M602INS\\network\\day03\\test.txt");
		fo = new FileOutputStream("testo.txt");
		BufferedInputStream bis = new BufferedInputStream(fi);
		BufferedOutputStream bos = new BufferedOutputStream(fo,5);
		System.out.println(fi.available()); // 몇 글자인지?
		int data =0;
		while((data=bis.read())!= -1) {
			System.out.print((char)data);
			bos.write(data);
			
		}
		if (fi != null) {			
			bis.close(); // 보조스트림의 close만으로 기반스트림의 처리가 된다.
		}
		if (fo != null) {
			bos.flush();
			bos.close();
		}
	}
}
