package refref;

public class Reftest {

	public static void main(String[] args) {
		Ref ref = new Ref();
		int b = 100;
		ref.sum2(ref); // call by reference
		System.out.println(ref.a);
		ref.sum(b); // call by value
		System.out.println(b);

	}

}
