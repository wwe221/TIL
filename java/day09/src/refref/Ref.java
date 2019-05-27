package refref;

public class Ref {
	int a;

	public void sum(int a) {
		a += 1000;
	}

	public void sum2 (Ref ref) {
		ref.a+=1000;
	}
	
}
