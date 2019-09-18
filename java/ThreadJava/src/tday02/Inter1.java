package tday02;

class Th1 extends Thread {
	@Override
	public void run() {
		while (!isInterrupted()) {
			System.out.println("Th1");
		}
	}
}
public class Inter1 {
	public static void main(String[] args) throws InterruptedException {
		Th1 th1 = new Th1();
		th1.start();
		System.out.println("end");
		Thread.sleep(5);
		th1.interrupt();

	}

}
