package ws;
public class Car {
//	2. 자동차
//	속성:시리얼(년원일시분초+1000, 이후 1001, 1002로 증가), 이름, 엔진, 색상
//	기능: 정보 출력
	private String serial;
	private String name;
	private Engine engine;
	private String color;
	private static int cnt;
	
	//initialization block
	{
		
	}
	static {
		cnt = 1000;		
	}
	
	public Car(String serial, String name, Engine eng, String color) {
		this.serial = serial + cnt++;
		this.name = name;
		this.engine = eng;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [serial=" + serial + ", name=" + name + ", eng=" + engine + ", color=" + color + "]";

	}

	public String getSerial() {
		return serial;
	}

	public String getName() {
		return name;
	}

	public Engine getEng() {
		return engine;
	}

	public String getColor() {
		return color;
	}

	public static int getCnt() {
		return cnt;
	}

}
