package programmers;

import java.util.Scanner;

public class LetterPress {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String exStr = sc.next();
        String bufStr = ""; //중복 검사를 위한 버퍼
        String resultStr = ""; //중복검사를 거친 결과값 문자열을 저장할 공간
        int bufCount = 1; //중복횟수

        //입력받은 문자열의 길이
        int resultLen = exStr.length();
        //반환할 최종 길이
        int resultCount = resultLen;

        //exStr/2의 몫 갯수만큼 쪼개서 사용합니다.
        for(int i = 1 ; i <= resultLen/2; i++) {
            //i개씩 j개덩어리로 잘라냅니다.
            for(int j = 1 ; j <= exStr.length()/i; j++) {
                //디버그용 계산 결과
                System.out.println("현재 추출한 값 : " + exStr.substring((j-1)*i , j*i)  + "   bufString에 있는 값 :"+bufStr);
                //이전에 계산했던 값과 일치하는지 확인합니다.
                if(bufStr.equals(exStr.substring((j-1)*i , j*i))) {
                    bufCount++;
                }else {
                    if(bufCount != 1) {
                        resultStr += Integer.toString(bufCount);
                        bufCount = 1;
                    }
                    resultStr += exStr.substring((j-1)*i , j*i);
                }
                bufStr = exStr.substring((j-1)*i , j*i);
            }
            //나머지 처리
            if(bufCount != 1) {
                resultStr += Integer.toString(bufCount);
                bufCount = 1;
            }
            if(resultLen % i != 0)
                resultStr += exStr.substring( resultLen - resultLen % i,resultLen);
            System.out.println("모든  결과 : "+resultStr);

            //만약 1로 쪼갰을 때의 길이보다 작다면
            if(resultStr.length() < resultCount) {
                resultCount = resultStr.length();
//                System.out.println("최선의 결과 : "+resultStr);
            }
            resultStr = "";
        }
        System.out.println(resultCount);
    }

}