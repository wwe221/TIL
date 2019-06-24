package com.ss;

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
 * Servlet implementation class ChartSevlet
 */
@WebServlet({ "/ChartSevlet", "/chart" })
public class ChartSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		for (int i = 0; i < 10; i++) {
			int temp = r.nextInt(10) + 1;
			JSONObject jo = new JSONObject();
			jo.put("rank", i+1);
			jo.put("keyword", "이경헌" + temp);
			if(temp%2==0) {				
				jo.put("type", "up");
			}
			else
				jo.put("type", "down");
			jo.put("cnt", temp);
			ja.add(jo);
		}
		out.print(ja.toJSONString());
		out.close();
	}

}
