package programmers;

import java.util.ArrayList;
import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/12913
public class DdangDdamuk {

	public static void main(String[] args) {
		int[][] lane = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 }};
		int[][] lane2 = { { 4, 3, 2, 1 }, { 2, 2, 2, 1 }, { 6, 6, 6, 4 },{8,7,6,5}};
		System.out.println(solution(lane));

	}
	private static int solution(int[][] land) {
		int answer = 0;
		int l = land.length;
		for(int i=1;i<l;i++) {
			for(int j=0;j<4;j++) {
				int sum=0;
				for(int k=0;k<4;k++) {
					if(j==k)
						continue;
					else
						sum= Math.max(sum, land[i-1][k]);					
				}
				System.out.println(sum);
				land[i][j]+=sum;
			}
		}
		for(int [] t : land) {
			System.out.println();
			for(int tmp : t)
				System.out.print(tmp+" ");
		}
		System.out.println();
		Arrays.sort(land[l-1]);
		answer=land[l-1][3];
		return answer;
	}	

}
