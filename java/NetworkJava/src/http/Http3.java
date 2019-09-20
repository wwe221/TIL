package http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Http3 {
	public static void main(String[] args) throws Exception{
		String id ="zukgeDDa";
		String pwd ="banga";
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
	}	
}