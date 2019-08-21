package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TestApp {

	public static void main(String[] args) throws Exception {
		RConnection rc = new RConnection("70.12.114.58");
		System.out.println("Connection OK");
		rc.setStringEncoding("utf8");
		rc.eval("source('C:/rstudio/r3/r09.R', encoding = 'UTF-8', echo=TRUE)");
		REXP rx2 = rc.eval("cole()");
		RList rlist = rx2.asList();
		double id[] = rlist.at("weight").asDoubles();
		double pwd[] = rlist.at("coles").asDoubles();
		JSONArray ja = new JSONArray();
		for (int i = 0; i < id.length; i++){
			JSONObject jo = new JSONObject();
			jo.put("ID", id[i]);
			jo.put("pwd", pwd[i]);
			ja.add(jo);
		}
		rc.close();				
		
		//데이터 1차 가공 id = weight, pwd = 콜레스테롤로 가정
		String WeightArray = "[";
		String colesterolArray = "[";
		for(int i=0;i<id.length;i++) {
			WeightArray += "'"+id[i]+"', ";
			colesterolArray += "'" +pwd[i]+"',";
		}
		WeightArray = WeightArray.substring(0, WeightArray.length()-1);
		colesterolArray = colesterolArray.substring(0,colesterolArray.length()-1);
		WeightArray+="]";
		colesterolArray+="]";
		JSONObject jsO = new JSONObject();
		jsO.put("weight", WeightArray);
		jsO.put("colesterol",colesterolArray);
		System.out.println(jsO);

	}

}
