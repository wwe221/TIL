package tday01;

class MYThread2 implements Runnable{
	String name = "myThread";
	public MYThread2(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " "+i);
		}
	}
}
public class Th2 {

	public static void main(String[] args) {
		MYThread2 a = new MYThread2("number1");
		Thread t= new Thread(a);
		t.start();		
		a= new MYThread2("@");
		t= new Thread(a);
		t.start();
	}

}
