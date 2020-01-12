package programmers;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/12899
public class Nara124 {

	public static void main(String[] args) {
		System.out.println(solution(9));
	}
	static public String solution(int n) {
		String answer ="";
		int a =0;
		while(n>0) {
			a= n%3;
			n/=3;
			if(a==0) {
				a= 4;
				n-=1;
			}
			answer= a+ answer;
			
		}
		return answer;
	}
}
