package ws;

public class Engine {
//1. 엔진
//속성:배기량, 엔진방식(4기통, 6기통)
//기능: 정보 출력
	private int displacement;
	private int type;

	public Engine(int cc, int egSize) {
		this.displacement = cc;
		this.type = egSize;
	}

	@Override
	public String toString() {
		return "Engine [cc=" + displacement + ", egSize=" + type + "]";
	}

	public int getCc() {
		return displacement;
	}


	public int getEgSize() {
		return type;
	}

}
