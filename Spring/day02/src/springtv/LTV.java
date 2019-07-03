package springtv;

import org.springframework.stereotype.Component;

@Component("ltv")
public class LTV implements TV {
	String status;
	int volume;
	
	@Override
	public void turnOn() {
		this.status = "LTV ON";
	}

	@Override
	public void turnOff() {
		this.status = "LTV OFF";
	}

	@Override
	public void volumeUp() {
		this.volume ++;
	}

	@Override
	public void volumeDown() {
		this.volume --;
	}

	@Override
	public String toString() {
		return "LTV [status=" + status + ", volume=" + volume + "]";
	}
	
}
