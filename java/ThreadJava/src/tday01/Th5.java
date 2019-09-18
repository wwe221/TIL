package tday01;
import java.util.Scanner;
class myCnt extends Thread{
	int t;	
	public myCnt(int i) {
		t = i;
	}
	@Override
	public void run() {
		for(int i=0;i<=t;i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
class start extends Thread{
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int l = scan.nextInt();
			myCnt m = new myCnt(l);
			new Thread(m).start();
		}
	}	
}
public class Th5 {
	public static void main(String[] args) {
		start s = new start();
		new Thread(s).start();
	}
}
