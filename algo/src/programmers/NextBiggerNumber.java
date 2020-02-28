package programmers;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/12911
public class NextBiggerNumber {

	public static void main(String[] args) {
		System.out.println(solution(78));

	}
	public static int solution(int n) {
	      int answer = 0;
	      int org = n;
	      int cnt = 0;
	      while(n>0) {
	    	  int a = n%2;
	    	  n/=2;
	    	  if(a==1)
	    		  cnt++;
	      }
	      boolean flag = true;
	      int cnt2 = 0;
	      int m = org;
	      int m2;
	      while(flag) {
	    	  m++;
	    	  m2=m;
	    	  while(m2>0) {
		    	  int a = m2%2;
		    	  m2/=2;
		    	  if(a==1)
		    		  cnt2++;
		      }
	    	  if(cnt == cnt2) {	    		  
	    		  flag=false;
	    		  answer=m;
	    		  break;
	    	  }
	    	  cnt2=0;
	      }
	      return answer;
	  }
}
