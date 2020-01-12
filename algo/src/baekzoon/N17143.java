package baekzoon;

import java.util.ArrayList;
import java.util.Scanner;

class Sh{
	int x, y;
	int spd;
	int dir;
	int size;
	public Sh(int x, int y, int spd, int dir, int size) {
		super();
		this.x = x;
		this.y = y;
		this.spd = spd;
		this.dir = dir;
		this.size = size;
	}
	
	
}
public class N17143 {
	static int n;
	static int m;
	static int l;
	static ArrayList<Sh> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		m= sc.nextInt();
		l= sc.nextInt();
		for(int i=0;i<l;i++) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			int spd= sc.nextInt();
			int dir= sc.nextInt();
			int size= sc.nextInt();
			list.add(new Sh(x, y, spd, dir, size));
		}
	}

}
