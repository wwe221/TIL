package springtv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sstv")
public class STV implements TV {
	String status;
	int volume;
	
	@Autowired
	Speaker spk;
	
	public STV() {
		System.out.println("Constructor STV ...");
	}
	public void startTV() {
		System.out.println("Start STV ...");
	}
	
	public void endTV() {
		System.out.println("End STV ...");
	}
	
	@Override
	public void turnOn() {
		this.status = "STV ON";
	}

	@Override
	public void turnOff() {
		this.status = "STV OFF";
	}

	@Override
	public void volumeUp() {
		spk.up();
	}

	@Override
	public void volumeDown() {
		spk.down();
	}
	@Override
	public String toString() {
		return "STV [status=" + status + ", volume=" + volume + "]";
	}

	
	
}




