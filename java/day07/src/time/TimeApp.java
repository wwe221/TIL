package time;

public class TimeApp {

	public static void main(String[] args) throws InterruptedException {
		Time myt = new Time();
		System.out.println(myt.toString());
		System.out.println(myt.getTime());
		Thread.sleep(1000);
		myt.Timing();
		myt.setAlarm(0, 0, 3);

	}

}
