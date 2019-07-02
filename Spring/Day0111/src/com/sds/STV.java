package com.sds;

public class STV implements TV {
	int size;
	private Speaker spk;
	public STV() {
		System.out.println("STV Construct");
	}
	public STV(int size) {	
		this.size = size;
	}
	public STV(int size, Speaker spk) {		
		this.size = size;
		this.spk = spk;
	}
	public void turnOn() {
		System.out.println("STV On");
	}
	public void turnOff() {
		System.out.println("STV Off");
	}
	public void up(){
		spk.up();
	}
	public STV(Speaker spk) {
		super();
		this.spk = spk;
	}
	public void print() {
		System.out.println("pringttt");
	}
	@Override
	public String toString() {
		return "STV [size=" + size + "]";
	}
	
}
