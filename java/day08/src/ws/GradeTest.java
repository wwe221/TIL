package ws;

import java.util.Arrays;
import java.util.Scanner;

public class GradeTest {
	//4과목의 점수를 입력 받는다.국어, 영어, 수학, 과학	
	//입력 예: 89 92 89 100
	//입력 받은 점수를 이용하여 다음을 출력 하시오
	//1. 합을 출력 하시오
	//2. 평균을 출력 하시오
	//3. 평균이 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 이하면 F
	//4. 최고점의 과목을 출력 하시오
	//5. 최하점의 과목을 출력 하시오
	//6. 오름차순 정렬 
	//7. 내림차순 정렬
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] grades = new int[4];;
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 ,영어 , 수학, 과학  네과목의 점수를 입력하세요");
		for(int i=0;i<4;i++)
			grades[i] = sc.nextInt();
		Grade myg = new Grade(grades);
		System.out.println("총 점수 :"+myg.sum());
		System.out.println("평균점수 :"+myg.avg());
		System.out.println("학점 :"+myg.grade());
		System.out.println("최고점수 :"+myg.maxsub());
		System.out.println("최하점수 :"+myg.minsub());
		System.out.println(Arrays.toString(myg.asort()));
		System.out.println(Arrays.toString(myg.dsort()));
		System.out.println();
	}

}
