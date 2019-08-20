import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class Test1 {

	public static void main(String[] args) throws Exception{
		int x =10;
		int y = 20;
		RConnection rc = new RConnection("70.12.114.58");
		System.out.println("Connection OK");
		rc.eval("source('C:/rstudio/r4/r05.R', echo=TRUE)");
		REXP rx = rc.eval("dd("+x+","+y+")");
		REXP rx2 = rc.eval("df()");
		RList rlist = rx2.asList();
		double result = rx.asDouble();
		System.out.println(result);
		double years [] = rlist.at("YEAR").asDoubles();
		double qts [] = rlist.at("QT").asDoubles();
		System.out.println(Arrays.toString(years));
		System.out.println(Arrays.toString(qts));
		JSONArray ja = new JSONArray();
		for(int i=0;i<years.length;i++) {
			JSONObject jo = new JSONObject();
			jo.put("YEAR",years[i]);
			jo.put("QT",qts[i]);
			ja.add(jo);
		}
		System.out.println(ja);
		rc.close();
	}

}
