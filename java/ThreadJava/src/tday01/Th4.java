package tday01;


class SaveThread extends Thread{
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("SAVE");						
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Th4 {
	public static void main(String[] args) throws InterruptedException {
		SaveThread st = new SaveThread();
		st.setDaemon(true);
		st.start();
		for(int i=0;i<10;i++) {
			Thread.sleep(500);
			System.out.println(i);
		}
	}

}
