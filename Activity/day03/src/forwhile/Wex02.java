package forwhile;

import java.util.Scanner;

public class Wex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye~...");
				sc.close();
				break;
			} else if (cmd.equals("i")) {
				System.out.println("Input 2 Numbs");
				int a = sc.nextInt();
				System.out.println(a);
			} else if (cmd.equals("s")) {
				System.out.println("Selected");
			} else {
				System.out.println("Re-Try");
				continue;
			}
			System.out.println("ÄÞÆÄ´Ï...");
		}//end while
		System.out.println("System Exit...");
	}
}