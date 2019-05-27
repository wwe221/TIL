package car;

public class CarApp {

	public static void main(String[] args) {
		Car mycar= new Car();
		System.out.println(mycar.toString());	
		mycar.lockOnoff();
		mycar.powerOnoff();
		mycar.sidebreak();
		mycar.gearing(4);
		mycar.accerateOn();
		System.out.println("시속 100까지 가속");
		while(mycar.isAccerator()) {
			mycar.addSpeed(2);
			mycar.sethandle(mycar.handle+1);
			if(mycar.getSpeed()>=20 && mycar.isLock()) {
				System.out.println(mycar.toString());
				mycar.lockOnoff();
				}	
			if(mycar.getSpeed() >=100)
				mycar.accerateOff();			
		}
		mycar.leftArrow();
		mycar.rightArrow();
		System.out.println(mycar.getSpeed());
		mycar.breakOn();
		while(mycar.isBreak()) {
			mycar.sethandle(mycar.handle-1);
			mycar.addSpeed(-20);
			if(mycar.getSpeed()<=0)
				mycar.breakOff();
		}		
		System.out.println(mycar.getSpeed());
		System.out.println(mycar.toString());
		
		
	}

}
