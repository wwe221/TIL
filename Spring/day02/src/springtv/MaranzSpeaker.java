package springtv;

import org.springframework.stereotype.Component;

@Component("ms")
public class MaranzSpeaker implements Speaker {

	@Override
	public void up() {
		System.out.println("Maranz Volume up");

	}

	@Override
	public void down() {
		System.out.println("Maranz Volume down");

	}

}
