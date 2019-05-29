package inter;

public class View {

	public static void main(String[] args) {
		Shop s = new Auction();
		s.register();
		s.login();
		s.order();
		s.logout();
		s = new Gmarket();
		s.register();
		s.login();
		s.order();
		s.logout();
	}

}
