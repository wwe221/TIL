package tv;

public class TvApp {

	public static void main(String[] args) {
		Tv tv = new Tv();
		System.out.println(tv.toString());		
		System.out.println(tv.toString());
		tv.power();
		tv.channelDown();
		System.out.println(tv.toString());
		Tv tv2 = new Tv();		
		System.out.println(tv2.toString());

	}

}
