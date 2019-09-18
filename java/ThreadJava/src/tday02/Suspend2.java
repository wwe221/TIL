package tday02;

import java.util.Scanner;

class Sus2 implements Runnable{
	
	boolean spd = false;
	boolean stp = false;
	@Override
	public void run() {
		while(!stp) {
			if(spd) {
				continue;
			}
			System.out.println("@@@@@@");

		
		}
	}
	public void setSuspend() {
		this.spd = !this.spd;
	}
	public void setStop() {
		this.stp = !this.stp;
	}
	
	
}
public class Suspend2 {

	public static void main(String[] args) {
		Sus2 sus2 = new Sus2();
		Thread t = new Thread(sus2,"s2");
		while(true) {
			System.out.println("input somth");
			Scanner sc = new Scanner(System.in);
			int temp = sc.nextInt();
			if(temp==0)				
				break;
			else if(temp==1) {
				sus2 = new Sus2();
				t= new Thread(sus2,"s2");
				t.start();
			}
			else if(temp==2) {
				sus2.setSuspend();
				System.out.println("suspend");
			}
			else if(temp==3) {
				sus2.setSuspend();
			}
			else if(temp==4) {
				sus2.setStop();
			}
		}
		System.out.println("ends main");
		
	}

}
