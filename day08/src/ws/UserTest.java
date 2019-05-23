package ws;

public class UserTest {

	public static void main(String[] args) {
		Engine e1 = new Engine(2000,4);
		Engine e2 = new Engine(4000,8);
		Car cs[] = new Car[2];
		cs[0] = new Car("20180102070823","SONATA",e1,"SILVER");
		cs[1] = new Car("20180105080050","Granduer",e2,"BLACK");
		User me = new User("¿Ã∞Ê«Â",cs);	
		System.out.println(me.toString());
		

	}

}
