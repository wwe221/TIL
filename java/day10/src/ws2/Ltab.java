package ws2;

public class Ltab extends Mobile {
	public Ltab() {

	}

	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}

	@Override
	public int operate(int time) {
		int a = this.getBatterySize();
		while (time-- >= 1) {
			a -= 10;
		}
		this.setBatterySize(a);
		return a;
	}

	

	@Override
	public int charge(int time) {
		int a = this.getBatterySize();
		while (time-- >= 1)
			a += 10;
		this.setBatterySize(a);
		return a;
	}

}
