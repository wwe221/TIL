package tv;

public class TvApp2 {
	public static void main(String[] args) {
		Tv tv = new Tv("blue",1,true);
		Tv tv2 = new Tv();
		Tv tv3 = new Tv("Black");
		System.out.println(tv.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3);
		tv3.setColor("");
		System.out.println(tv3.getColor());
		
	}

}
