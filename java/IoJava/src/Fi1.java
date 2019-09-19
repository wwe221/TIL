import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fi1 {
	public static void main(String [] args) {
		FileInputStream fi = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fi = new FileInputStream("text.txt");
			int data =0 ;			
			while((data=fi.read())!= -1) { // -1 이면 문장의 끝
				char c = (char) data;
				System.out.println(c);
			}
			fr = new FileReader("text.txt");
			br = new BufferedReader(fr);
			String str ;
			while( (str = br.readLine()) != null) {
				System.out.println(str);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fi!=null)
					fi.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				try {
					Thread.sleep(2000);
					fi.close();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
