package http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class Http1 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://70.12.60.90/test");
		URLConnection conn = url.openConnection();
		InputStream is =conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String data;
		StringWriter sw = new StringWriter();
		while((data = br.readLine())!=null) {
			sw.write(data);
			sw.write("\n");
		}
		System.out.println(sw.toString());
		sw.close();
	}
}
