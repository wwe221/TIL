package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr3 {
	public static void main(String[] args) {
		// 5 명 성적 출력
		// 점수 1 ~ 100
		// 국어 영어 수학 과학
		// 단 배열에 첫번째는 학번이 들어간다
		int[][] std = new int[4][4];
		Random ran = new Random();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				std[i][j] = ran.nextInt(100) + 1;
			}
		}
		for (int i[] : std)
			System.out.println(Arrays.toString(i));
		// 학생별 평균 , 과목별 평균 , 전체평균 출력
		float st[] = new float[4];
		float subb[] = new float[4];
		int cnt = 0;
		int sum;
		int sum2;
		int sum3 = 0;
		float avg;
		for (int i = 0; i < std.length; i++) {
			sum = 0;
			sum2 = 0;
			for (int j = 0; j < std[0].length; j++) {
				sum += std[i][j];
				sum2 += std[j][i];
			}
			sum3 += sum;
			st[i] = (float) sum / std.length;
			subb[i] = (float) sum2 / std[0].length;
		}
		avg = sum3 / (std.length * std[0].length);
		System.out.println("\n학생별 평균");
		for (float i : st) {
			System.out.printf("%2.1f  ", i);
		}
		System.out.println("\n과목별 평균");
		for (float i : subb) {
			System.out.printf("%2.1f  ", i);
		}
		System.out.println("\n전체 평균");
		System.out.print(avg);
	}
}
