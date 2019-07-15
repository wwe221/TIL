import java.util.ArrayList;

import com.biz.ContentBiz;
import com.controller.Naver;
import com.frame.Biz;
import com.vo.Content;

public class App {

	public static void main(String[] args) {
		Naver a = new Naver();
		ArrayList<String> b=new ArrayList<String> ();
		b= a.movieinsert("2015","2016");
		Content c=a.details(b.get(0));
		Biz<Integer,Content> biz = new ContentBiz();
		System.out.println(biz);
		try {
			biz.insert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
