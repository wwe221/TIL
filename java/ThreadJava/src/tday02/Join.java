package tday02;

class Th2 extends Thread {
	int sum =0;
	public int getSum() {
		return sum;
	}
	@Override
	public void run() {
		int i=0;
		while (!isInterrupted()) {
			sum+=i;
			if(i==10)
				return;
			i++;
		}
		System.out.println("Thread end");
	}	
}
public class Join {

	public static void main(String[] args) throws InterruptedException {
		Th2 th2 = new Th2();
		th2.start();
		th2.join();
		System.out.println("sum:"+th2.getSum());
	}

}
