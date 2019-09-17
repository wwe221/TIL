package tday01;

public class Th3 {
	public static void main(String[] args) {
		Runnable r= new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("R:"+i);
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		};
		Runnable r2= new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("R2:"+i);
				}
				
			}
		};
		ThreadGroup tg1 = new ThreadGroup("TG1");		
		tg1.setMaxPriority(3);
		new Thread(tg1,r,"th1").start();
		System.out.println(tg1.activeCount());
		new Thread(tg1,r2,"th2").start();
	}
}
