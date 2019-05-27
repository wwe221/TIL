package tv;

public class Tv {
	// attribute
	private String color;
	private int channel;
	private boolean power;

	// constructor
	Tv() {
		color = "red";
		channel = 10;
		power = true;
	}

	Tv(String color) {
		this.color = color;
		channel = 7;
		power = false;
	}

	Tv(String color, int b, boolean c) {
		this.color = color;
		this.channel = b;
		this.power = c;
	}
	// function
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if (color.equals("") || color == null)
			return;

		this.color = color;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
	void power() {
		power = !power;
	}	
	@Override
	public String toString() {
		return "Tv [color=" + color + ", channel=" + channel + ", power=" + power + "]";
	}
}
