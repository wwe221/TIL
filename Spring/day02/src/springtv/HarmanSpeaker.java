package springtv;

import org.springframework.stereotype.Component;


public class HarmanSpeaker implements Speaker {
	
	@Override
	public void up() {
		System.out.println("Harman Volume up");

	}

	@Override
	public void down() {
		System.out.println("Harman Volume down");

	}

}
