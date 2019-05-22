package ws;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
//		1. 소문자로 된 문자열을 입력 받아 출력 한다.
//		2. 입력 받은 문자열을 대문자로 만들어 순서를 꺼꾸로 하여 출력 한다.
//		3. 2번에서 만들어진 문자열의 각 char에 +5를 하여 암호화 하여 출력 한다.
//		4. 3번에서 만들어진 문자열을 복호화 하여 최초 입력 받은 문자열을 출력 한다. 
		String in = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("소문자 문자열을 입역하세요");
		in = sc.nextLine();
		String save = "";
		String out = "";
		for (int i = 0; i < in.length(); i++) {// 대문자로 변환하기위해 32빼기
			save += (char) (in.charAt(i) - 32);
		}
		System.out.println(save);
		in = save;
		save = "";
		for (int i = in.length() - 1; 0 <= i; i--) { // 순서 바꾸기
			save += in.charAt(i);
		}
		System.out.println(save);
		in = save;
		save = "";
		for (int i = 0; i < in.length(); i++) { // 암호화
			save += (char) (in.charAt(i) + 5);
		}
		System.out.println(save);
		for (int i = in.length() - 1; 0 <= i; i--) {// 복호화
			out += (char) (save.charAt(i) + 27);
		}
		System.out.println(out);
	}

}
