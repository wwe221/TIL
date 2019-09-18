package tday02;

class t1 extends Thread{
	int i;
	
	public t1(int i) {
		this.i = i;
	}
	public void run() {
		t2 t= new t2(i);
		t.start();
		int a = 0;
		while(true) {
			if(a==i) {
				break;
			}
			System.out.println("t1: " + a++);
		}
	}
}
class t2 extends Thread{
	int i;
	public t2(int i) {
		this.i=i;
	}
	public void run() {		
		while(true) {
			if(i==0)
				break;
			System.out.println("t2: " + i--);
		}
	}
}
public class Ws {
	public static void main(String[] args) {
		t1 t = new t1(100);
		t.start();
	}

}
