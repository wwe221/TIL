package tday02;

class hundredDDD implements Runnable{
	int i=0;
	int j=0;
	
	public hundredDDD(int i, int j) {		
		this.i = i;
		this.j = j;
	}
	int sum=0;
	@Override
	public void run() {		
		while(true) {
			sum+=i++;
			if(i==j)
				return;
		}
	}
	public int getSum() {
		return sum;
	}	
}


class hundred implements Runnable{
	int i=0;
	int sum=0;
	@Override
	public void run() {		
		while(true) {
			sum+=i++;
			if(i==100)
				return;
		}
	}
	public int getSum() {
		return sum;
	}	
}
class hundredFif implements Runnable{
	int i=101;
	int sum=0;
	@Override
	public void run() {		
		while(true) {
			sum+=i++;
			if(i==150)
				return;
		}
	}
	public int getSum() {
		return sum;
	}
}
public class Join2 {
	public static void main(String[] args) throws InterruptedException {
		hundredDDD h3 = new hundredDDD(1, 100);
		hundredDDD h4 = new hundredDDD(101, 150);
		Thread t1 = new Thread(h3);
		Thread t2 = new Thread(h4);
		t1.start();
		t2.start();
		System.out.println("Threads started");
		t1.join();
		t2.join();
		int result = h3.getSum()+h4.getSum();
		System.out.println(result);
	}
}
