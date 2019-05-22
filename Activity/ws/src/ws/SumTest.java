package ws;

import java.util.Arrays;
import java.util.Random;

public class SumTest {

	public static void main(String[] args) {

		Random ran = new Random();
		int[] numb = new int[100];
		boolean[] check = new boolean[101];
		int[] holl = new int[50];
		int[] zak = new int[50];
		int[] sum = new int[50];
		int r;
//		1. 100개의 정수형 배열에 1~100까지의 숫자를 난수로 발생 시킨다. 중복 허용하지 않는다. 
		for (int i = 0; i < numb.length; i++) {
			while (true) {
				r = ran.nextInt(100) + 1;
				if (!check[r]) {
					check[r] = true;
					numb[i] = r;
					break;
				}
			}
		}
//		2. 짝수 번째에 있는 정수들만 50개의 배열에 저장
//		3. 홀수 번째에 있는 정수들만 50개의 배열에 저장 
		for (int a = 0, b = 0, i = 0; i < numb.length; i++) {
			if (i % 2 == 0) {
				zak[b++] = numb[i];
			} else
				holl[a++] = numb[i];
		}
		System.out.println("짝수번째 항");
		System.out.println(Arrays.toString(zak));
		System.out.println("홀수 번째 항");
		System.out.println(Arrays.toString(holl));
//		4. 짝수 번째 배열의 첫번째 숫자와 홀수 번째 배열의 마지막 숫자를 합산, 
//		다시 짝수 번째 두번째 숫자는 홀수 번째 배열의 마지막에서 두번째 숫자와의 
//		합산 ....... 이런식으로 합산한 결과를 출력 하시오
		int len = holl.length - 1;
		System.out.println("짝수번째  + 홀수 번째");
		for (int i = 0; i <= len; i++)
			sum[i] = zak[i] + holl[len - i];
		System.out.println(Arrays.toString(sum));

	}
}
