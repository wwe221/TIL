import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class Test2 {

	public static void main(String[] args) throws Exception{
		int x =10;
		int y = 20;
		RConnection rc = new RConnection("70.12.114.58");
		System.out.println("Connection OK");
		rc.setStringEncoding("utf8");
		rc.eval("source('C:/rstudio/r4/r05.R', echo=TRUE,encoding='UTF-8')");
		REXP rx2 = rc.eval("db()");
		RList rlist = rx2.asList();
		String id[] = rlist.at("ID").asStrings();
		String pwd [] = rlist.at("PWD").asStrings();
		String email [] = rlist.at("EMAIL").asStrings();
		String nick[] = rlist.at("NICKNAME").asStrings();
		System.out.println(Arrays.toString(id));
		System.out.println(Arrays.toString(pwd));
		JSONArray ja = new JSONArray();
		for(int i=0;i<id.length;i++) {
			JSONObject jo = new JSONObject();
			jo.put("ID",id[i]);
			jo.put("pwd",pwd[i]);
			jo.put("email",email[i]);
			jo.put("nick",nick[i]);
			ja.add(jo);
		}
		System.out.println(ja);
		rc.close();
	}

}
