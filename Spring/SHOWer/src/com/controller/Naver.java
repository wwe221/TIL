package com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.vo.Content;
import com.vo.User;

public class Naver {
	public static StringBuilder sb;
	public static StringBuilder ssbb;

	public static ArrayList<Content> getMovies(int a, int b) {// a년도 부터 b 년도 까지의 매년 100개씩의 영화를 담은 list 리턴
		ArrayList<Content> list = new ArrayList<>();
		ArrayList<String> allCodes = new ArrayList<>();
		ArrayList<String> code = new ArrayList<>();
		// a년 부터 b 년 까지의 코드들을 저장하자
		for (int i = a; i < b; i++) {
			code = movieinsert(i, i + 1);
			for (int j = 0; j < code.size(); j++) {
				allCodes.add(code.get(j));
			}
		}
		System.out.println(allCodes.size());
		for (int i = 0; i < allCodes.size(); i++) {
			list.add(details(allCodes.get(i)));
		}
		return list;
	}

	public static Content details(String code) {// 영화 하나의 상세 정보를 갖고온다.
		String title = "";
		String genre = "";
		String poster = "";
		String director = "test";
		String actor1 = "";
		String actor2 = "";
		String actor3 = "";
		int time = 0;
		String contry = "";
		String grade = "";
		String open = "";
		double rating = 0;
		String apiurl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=298fb66cdb0e78493a307a5f6cc7b71f&movieCd="
				+ code;
		try {
			URL url = new URL(apiurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			ssbb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				ssbb.append(line + "\n");
			}
			br.close();
			con.disconnect();
			String data = ssbb.toString();
			String[] array;
			int k = 0;
			array = data.split("\"");

			for (int i = 0; i < array.length; i++) {
				if (array[i].equals("movieNm")) {
					title = array[i + 2];
				}
				if (array[i].equals("openDt")) {
					open = array[i + 2];
				}
				if (array[i].equals("genreNm")) {
					genre = array[i + 2];
				}
				if (array[i].equals("showTm")) {
					time = Integer.parseInt(array[i + 2]);
				}
				if (array[i].equals("nationNm")) {
					contry = array[i + 2];
				}
				if (array[i].equals("directors")) {
					director = array[i + 4];
				}
				if (array[i].equals("actors")) {
					actor1 = array[i + 4];
					actor2 = array[i + 20];
					actor3 = array[i + 36];
				}
				if (array[i].equals("watchGradeNm")) {
					grade = array[i + 2];
				}
			}
			poster = getImg(title);
			rating = getRating(title);
			if (poster == null) {
				poster = "view/img/noimg.jpg";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Content movie = new Content(1, title, open, genre, poster, director, actor1, actor2, actor3, time, contry,
				grade, rating);

		return movie;
	}

	public static ArrayList<String> movieinsert(int a, int b) {// a년 부터 b년 까지의 영화 100개의 codes를 리턴한다.
		String key = "298fb66cdb0e78493a307a5f6cc7b71f";

		String apiurl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=298fb66cdb0e78493a307a5f6cc7b71f&itemPerPage=100&"
				+ "openStartDt=" + a + "&openEndDt=" + b;
		try {
			URL url = new URL(apiurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			ssbb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				ssbb.append(line + "\n");
			}
			br.close();
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = ssbb.toString();
		String[] array;
		array = data.split("\"");
		ArrayList<String> codes = new ArrayList<>();
		String[] code = new String[500];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("movieCd")) {
				codes.add(array[i + 2]);

			}
		}
		return codes;
	}

	public static double getRating(String title) {
		String clientId = "7V0JoawWKWNz3PukrXhK";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "U_XEWugoxb";// 애플리케이션 클라이언트 시크릿값";\
		int display = 100; // 검색결과갯수. 최대100개
		try {
			String intext = title;
			String text = URLEncoder.encode(intext, "utf-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text + "&display=10&start=1"
					+ "&display=" + display + "&";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			con.disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		String data = sb.toString();
		String[] array;
		array = data.split("\"");
		double[] rating = new double[500];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("userRating")) {
				rating[k] = Double.parseDouble(array[i + 2]);
				k++;
			}
		}
		return rating[0];
	}

	public static String getImg(String title) {
		String clientId = "7V0JoawWKWNz3PukrXhK";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "U_XEWugoxb";// 애플리케이션 클라이언트 시크릿값";\
		int display = 100; // 검색결과갯수. 최대100개
		try {
			String intext = title;
			String text = URLEncoder.encode(intext, "utf-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text + "&display=10&start=1"
					+ "&display=" + display + "&";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			con.disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		String data = sb.toString();
		String[] array;
		array = data.split("\"");
		String[] t = new String[500];
		String[] image = new String[500];
		double[] rating = new double[500];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("title")) {
				t[k] = array[i + 2];
			}
			if (array[i].equals("image"))
				image[k] = array[i + 2];
			if (array[i].equals("userRating")) {
				rating[k] = Double.parseDouble(array[i + 2]);
				k++;
			}
		}
		return image[0];
	}

	public static ArrayList<Content> test() {
		String title = "";
		String open = "";
		String close = "";
		String genre = "";
		String poster = "";
		String place = "";
		double lox = 0;
		double loy = 0;
		ArrayList<Content> list = new ArrayList<>();
		BufferedReader br = null;
		// DocumentBuilderFactory 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			// OpenApi호출
			String urlstr = "http://www.culture.go.kr/openapi/rest/publicperformancedisplays/area?"
					+ "serviceKey=WxGYfZlOF6WK6Uofs7A%2FFXIladK%2BrrfYUBnqcnuyGv9cob5ue6BINRwzj%2Fd0ZcggXbCcRLbch2hFjppwe4vU7g%3D%3D"
					+ "&rows=100" + "&from=20180101" + "&to=20200101";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// 응답 읽기
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line.trim();// result = URL로 XML을 읽은 값
			}
			// xml 파싱하기
			InputSource is = new InputSource(new StringReader(result));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//msgBody/perforList");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				NodeList child = nodeList.item(i).getChildNodes();
				for (int j = 0; j < child.getLength(); j++) {
					Node node = child.item(j);
					if (node.getNodeName().equals("title")) {
						title = node.getTextContent();
					}
					if (node.getNodeName().equals("startDate")) {
						open = node.getTextContent();
					}
					if (node.getNodeName().equals("endDate")) {
						close = node.getTextContent();
					}
					if (node.getNodeName().equals("place")) {
						place = node.getTextContent();
					}
					if (node.getNodeName().equals("realmName")) {
						genre = node.getTextContent();
					}
					if (node.getNodeName().equals("thumbnail")) {
						poster = node.getTextContent();
					}
					if (node.getNodeName().equals("gpsX")) {
						lox = Double.parseDouble(node.getTextContent());
					}
					if (node.getNodeName().equals("gpsY")) {
						loy = Double.parseDouble(node.getTextContent());
					}
//	                    System.out.println("현재 노드 이름 : " + node.getNodeName());
//	                    System.out.println("현재 노드 타입 : " + node.getNodeType());
//	                    System.out.println("현재 노드 값 : " + node.getTextContent());
//	                    System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
//	                    System.out.println("현재 노드의 다음 노드 : " + node.getNextSibling());
//	                    System.out.println("");
				}
				Content c = new Content(2, title, open, close, genre, poster, place, lox, loy);
				list.add(c);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
