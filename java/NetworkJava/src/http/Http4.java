package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

class cThread extends Thread {
	String id;
	String pwd;
	public cThread(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public void run() {		
		try {
			URL url = new URL("http://70.12.60.90/test/login.jsp?id="+id+"&pwd="+pwd);		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(10000);
			InputStream a= conn.getInputStream();
			InputStreamReader is = new InputStreamReader(a);
			BufferedReader br = new BufferedReader(is);
			if(conn.getResponseCode() ==HttpURLConnection.HTTP_OK) {
				String str;
				while((str=br.readLine())!=null)
					System.out.println(str);			
			}
			else {
				System.out.println("Err");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class Http4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String pwd = sc.next();
		cThread a = new cThread(id, pwd);
		a.start();
	}
}
