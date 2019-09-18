package tday02;

import java.util.Scanner;

class Sus implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("@@@@@@");
			/*
			 * System.out.println(Thread.currentThread().getName()
			 * +" "+Thread.currentThread().getId());
			 */
		}
	}
	
}
public class Suspend {

	public static void main(String[] args) {
		Thread t = new Thread(new Sus(),"s1");
		while(true) {
			System.out.println("input somth");
			Scanner sc = new Scanner(System.in);
			int temp = sc.nextInt();
			if(temp==0)
				break;
			else if(temp==1) {
				t.start();
			}
			else if(temp==2) {
				t.suspend();
				System.out.println("suspend");
			}
			else if(temp==3) {
				t.resume();
			}
			else if(temp==4) {
				t.stop();
			}
		}
		System.out.println("ends main");
		
	}

}
