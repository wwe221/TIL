package ifswitch;

public class Game2 {
	public static void main(String[] args) {
		String str = "Mymail@gmail.com";
		int a = str.indexOf("@");
		
		String re = str.substring(0, a);
		String domain = str.substring(a + 1, str.indexOf("."));
		System.out.println(re);
		System.out.println(domain);
	}
}
