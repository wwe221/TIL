import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Fi3 {
	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("text.txt");
		FileWriter wr = new FileWriter("text2.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(wr);
		String str;
		while((str= br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			System.out.println(str);
		}
		if(br!=null) {
			br.close();
			bw.close();
		}
	}
}
