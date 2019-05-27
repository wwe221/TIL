package car;
public class Car {
  private String brand;
  private String model;
  private String powerType;
  public String color;
  public float fuelEfficiency;
  public int horsePower;
  public int maxSpeed;
  private boolean power;
  public int speed;
  private boolean accerator;
  private boolean breaker;
  private boolean sideBreak;
  public boolean leftArrow;
  public boolean rightArrow;
  public boolean breakLight;
  private boolean lock;
  public float handle;
  public int gear;
  public int wheelDrive;
  Car(){
	  brand = "BMW";
	  model = "740m";
	  powerType= "gasoline";
	  color = "blue";
	  fuelEfficiency= 10;
	  horsePower = 300;
	  maxSpeed =300;
	  power=false;
	  speed=0;
	  accerator = false;
	  breaker= false;
	  sideBreak = true;
	  leftArrow= false;
	  rightArrow= false;
	  breakLight= false;
	  lock = false;
	  handle=0;
	  gear = 6;
  }
  public void powerOnoff() {
	  power = !power;
  }  
  public void accerateOn() {
	  this.accerator = true;
  }
  public void accerateOff() {
	  this.accerator = 	false;
  }
  public boolean isAccerator() {
	  return this.accerator;
  }
  public void addSpeed(int speed) {
	  this.speed +=speed;
  }
  public int getSpeed() {
	  return this.speed;
  }
  public void breakOn() {
	  this.breaker = true;
  }
  public void breakOff() {
	  this.breaker = false;
  }
  public boolean isBreak() {
	  return this.breaker;
  }
  public void lockOnoff() {
	  this.lock = !this.lock;
  }
  public boolean isLock() {
	  return this.lock;
  }
public void sidebreak() {
	  this.sideBreak = !this.sideBreak;
  }
  
  public void leftArrow() {
	  this.leftArrow = ! this.leftArrow ;
  }
  
  public void rightArrow() {
	  this.rightArrow = ! this.rightArrow ;
  }
  
  public void sethandle(float handle) {
	  this.handle = handle;
  }  
  public void gearing(int gear) {
	  this.gear = gear;
  }
@Override
public String toString() {
	return "Car [brand=" + brand + ", model=" + model + ", powerType=" + powerType + ", color=" + color + ", speed="
			+ speed + ", leftArrow=" + leftArrow + ", rightArrow=" + rightArrow + ", handle=" + handle + ", gear="
			+ gear + "]";
}
  
}
