package programmers;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/62049
public class PaperFold {

public static void main(String[] args) {
		
		int n = 4;
		
		int[] answer = solution(n);
		
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int n) {
		
		
		// v는 0, ^는 1
		// 1번 접을 때 [ 0 ]
		// 2번 접을 때 [ 0,0,1 ]
		// 3번 접을 때 [ 0,0,1,0,0,1,1 ]
		// 4번 접을 때 [ 0,0,1,0,0,1,1,0,0,0,1,1,0,1,1]
		
		if ( n==1 ) {
			int[] answer = { 0 } ;
			return answer;
		}
		
		String result = "";
		
		for ( int i = 1; i <= n ; i++ ) {
			result = calc(i,result);
		}
		
		int[] answer = new int[result.length()];
		
		String[] sS = result.split("");
		
		for ( int i = 0 ; i < answer.length; i ++ ) {
			answer[i] = Integer.valueOf(sS[i]);
		}
		return answer;
	}
	
	private static String calc(int i , String s ) {
		
		StringBuilder result = new StringBuilder(s);
		
		if ( i == 1 ) return "0";
		
		else {
			result.append("0");
			
			String[] splitS = s.split("");
			
			for ( int j = splitS.length-1; j >= 0 ; j-- ) {
				String appendS = splitS[j].equals("0") ? "1" : "0" ;
				result.append(appendS);				
			}
		}
		return result.toString();
	}	
}