package programmers;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42747
public class H_index {

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		int l = citations.length;		
		Arrays.sort(citations);
		for (int i = 0; i < l; i++) {
			int h = l - i;
			if (citations[i] >= h) {
                answer = h;
                break;
            }
		}
		return answer;
	}

}
