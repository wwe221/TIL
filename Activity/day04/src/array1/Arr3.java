package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr3 {

	public static void main(String[] args) {
		// 10~ 99 까지 숫자랜덤하게 배열에 입력
		// 합과 평균 구해
		int[] a = new int[5];
		int[] aa = new int[30];
		Random ran = new Random();
		int sum = 0;
		float avg;
		int min = 100, max = 0;
		for (int i = 0; i < 5; i++) {
			int b = ran.nextInt(90) + 10;
			sum += b;
			a[i] = b;
		}
		avg = (float) sum / a.length;
		System.out.println(Arrays.toString(a));
		System.out.println(sum + " " + avg);
		System.out.println("-----------------------------");
		for (int i : a) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		System.out.printf("최댓값: %d 최소값: %d\n", max, min);
		System.out.println("-----------------------------");
		// 작은수 부터 정렬쓰
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		// 큰 수 부터 정렬
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] < a[j + 1]) {
					int tmp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println("-----------------------------");
		for (int i = 0; i < aa.length; i++)
			aa[i] = ran.nextInt(90) + 10;
		int[] cnt = new int[90];
		for (int i : aa)
			cnt[i - 10]++;
		System.out.println(Arrays.toString(cnt));
	}

}
