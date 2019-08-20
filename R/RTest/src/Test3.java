import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class Test3 {

	public static void main(String[] args) throws Exception{
		RConnection rc = new RConnection("70.12.114.58");
		System.out.println("Connection OK");
		rc.setStringEncoding("utf8");
		rc.eval("source('C:/rstudio/r4/r05.R', echo=TRUE,encoding='UTF-8')");
		REXP rx2 = rc.eval("rhive()");
		RList rlist = rx2.asList();
		String id[] = rlist.at("hdi.country").asStrings();
		String pwd [] = rlist.at("hdi.hdi").asStrings();
		JSONArray ja = new JSONArray();
		for(int i=0;i<id.length;i++) {
			JSONObject jo = new JSONObject();
			jo.put("ID",id[i]);
			jo.put("pwd",pwd[i]);

			ja.add(jo);
		}
		System.out.println(ja);
		rc.close();
	}

}
