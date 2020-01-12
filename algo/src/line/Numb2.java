package line;

import java.util.Stack;

class Numb2 {
       public static String solution(String ecryptedString) {
        String answer = ecryptedString;
        Stack<Integer> stack = new Stack<Integer>();
        int index;
        String temp;
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i) == '{'){
                stack.push(i);
            }
            else if(answer.charAt(i) == '}'){
                index = stack.pop();
                String ss = answer.substring(index+1,i);
                String post = answer.substring(i+1,answer.length());
                String pre = answer.substring(0,index-1);
                temp = pre;
                for(int j=0;j<(Integer)(answer.charAt(index-1)-'0');j++) {
                   temp+= ss;
                }
                temp += post;
                answer= temp;
                i -= 2;
            }
        }
        return answer;
    }

}