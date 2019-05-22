package day02;

public class Operator2 {
	public static void main(String[] args) {
		// 소숫점 3자리이하 버림 계산하고 출력
		// 소숫점 3자리이하 반올림 계산하고 출력
		double d = 3.141592;
		double a, b;
		a = (int) (d * 1000);
		a /= 1000.0;
		b = (int) (d * 1000 + 0.5) / 1000d;
		System.out.println(a + "\n" + b);

		a = Math.floor(d * 1000) / 1000d;
		b = Math.round(d * 1000) / 1000d;
		System.out.println(a + "\n" + b);

		// 가로세로가 5,4인 삼각형의 빗변의 길이를 구해라
		int x = 5, y = 4;
		double z;
		z = Math.sqrt(x * x + y * y);
		System.out.println(z);
		System.out.println(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));

	}
}
