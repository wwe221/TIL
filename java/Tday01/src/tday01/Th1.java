package tday01;

class MyThread extends Thread{
	String name = "myThread";
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<10000;i++) {			
			System.out.println(name + " "+i);
			
		}
		yield();
		System.out.println(name+"endddddddddddddddddddddddddddddddddddd");
	}
}
public class Th1 {

	public static void main(String[] args) {
		Thread a = new MyThread("11");
		Thread b = new MyThread("22");
		Thread c = new MyThread("33");
		Thread d = new MyThread("44");
		Thread e = new MyThread("55");
		Thread f = new MyThread("66");
		a.setPriority(10);
		b.setPriority(4);
		c.setPriority(4);
		a.start();
		b.start();
		c.start();
		
		
	}

}
