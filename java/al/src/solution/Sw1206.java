package solution;

import java.util.Scanner;

public class Sw1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 0;
		size = sc.nextInt();
		int input = 0;
		int a;
		// for(int z=0;z<size;z++) {
		input = sc.nextInt();
		Bud b[] = new Bud[input];
		for (int i = 0; i < input; i++) {
			b[i].h = sc.nextInt();
		}
		
		

		// } end for z

	}

}

class Bud {
	int h;
	int s = 0;
}
