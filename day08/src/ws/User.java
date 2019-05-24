package ws;

import java.util.Arrays;

public class User {
	private String name;
	private Car[] cars;	
	public User(String name, Car[] car ) {
		this.name = name;
		this.cars = car;
	}	

	@Override
	public String toString() {
		return "User [name=" + name + ", cars=" + Arrays.toString(cars) + "]";
	}

}
