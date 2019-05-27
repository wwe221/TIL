package bank;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = null;
		Account acc2 = null;
		
		try {	
			acc1 = new Account("Lee", "12345", 10000);
			acc2 = new Account("Kim", "98765", 20000);
			System.out.println(Account.cnt);
			
		} catch (Exception e) {
			if(e.getMessage().equals("E0002"))
				System.out.println("ÀÜ¾× ºÎÁ·");						
		}
		

	}

}
