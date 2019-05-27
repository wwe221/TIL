package shape;

public class ShapeTest {

	public static void main(String[] args) {
		// Shape s = new Shape(new Point(3,3));
		// 추상클래스 이기 때문에 직접 객체 생성은 불가능하다.

		// Heterogeneous Collection
		// 서로 다른 종류의 클래스들을 하나의 집합체로 구현할 수 있다.
		Shape s[] = new Shape[3];
		s[0] = new Circle(new Point(3, 3), 5);
		s[1] = new Triangle(new Point(1, 1), 5, 6);
		s[2] = new Rectangle(new Point(1, 1), 4, 5);
		// Polymorphism 다형성.
		for (Shape sh : s) {
			sh.mov(0, 0);
			if (sh instanceof Circle) {
				((Circle) sh).fillColor("BloodRed");
				// Circle c= (Circle) sh; c.fillColor();
			}
			System.out.println(sh);
			System.out.println(sh.getArea());
			System.out.println(sh.getCircume());
		}
		((Circle) s[0]).fillColor("niceBlue");
		System.out.println(s[0]);

	}

}
