package ws2;

public class Otab extends Mobile {

	public Otab() {

	}

	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}

	@Override
	public int operate(int time) {
		int a = this.getBatterySize();
		while (time-- >= 1)
			a -= 12;
		this.setBatterySize(a);
		return a;
	}

	@Override
	public int charge(int time) {
		int a = this.getBatterySize();
		while (time-- >= 1)
			a += 8;
		this.setBatterySize(a);
		return a;
	}

}
