package com.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class Chart
 */
@WebServlet({ "/Chart", "/chart" })
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		int tmp = r.nextInt(5)+1;
		String[] img = { "img/mv1.jpg", "img/mv2.jpg", "img/mv3.jpg", "img/mv4.jpg", "img/mv5.jpg" };
		for (int i = 1; i <= 5; i++) {
			JSONObject jo = new JSONObject();
			jo.put("rank", i);			
			jo.put("img", img[i*tmp%5]);
			ja.add(jo);
		}
		
		out.print(ja.toJSONString());
		out.close();
	}

}
