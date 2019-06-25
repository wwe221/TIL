package com.ss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet({ "/Chart1", "/chart1" })
public class Chart1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * [ { name: 'Seoul', data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3,
		 * 18.3, 13.9, 9.6] }, { name: 'Gosung', data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2,
		 * 17.0, 16.6, 14.2, 10.3, 6.6, 4.8] },{ name: 'Busan', data: [13.9, 14.2, 15.7,
		 * 18.5, 21.9, 25.2, 27.0, 26.6, 24.2, 20.3, 16.6, 14.8] } ]
		 */
		Random r = new Random();
		String[] name = { "Seoul", "Busan", "Daegu" };
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		float[] data = new float[12];
		JSONArray ja = new JSONArray();
		for (int i = 0; i < 3; i++) {

			JSONObject jo = new JSONObject();
			jo.put("name", name[i]);
			JSONArray js = new JSONArray();
			for (int j = 0; j < 12; j++) {
				js.add(r.nextInt(30) + 1);
			}
			jo.put("data", js);
			ja.add(jo);
		}

		out.print(ja.toJSONString());
		out.close();

	}

}
