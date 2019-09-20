package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class Http2 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://70.12.60.90/test/oracle.zip");
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		FileOutputStream fo = new FileOutputStream("output.zip");
		BufferedOutputStream bos = new BufferedOutputStream(fo);
		int dat =0;
		BufferedInputStream br = new BufferedInputStream(is,1024);
		while((dat = br.read())!=-1) {
			bos.write(dat);
		}
		System.out.println("Finishhhh.....");
		br.close();
		bos.flush();
		bos.close();
	}
}
