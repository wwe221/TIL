package tv;

public class TvApp3 {
	public static void main(String[] args) {
		Tv tvs[] = new Tv[3];
		tvs[0] = new Tv("Black");
		tvs[1] = new Tv("blue");
		tvs[2] = new Tv();
		for (Tv i : tvs)
			System.out.println(i);
	}

}
