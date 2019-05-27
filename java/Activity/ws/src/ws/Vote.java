package ws;
import java.util.Arrays;
import java.util.Random;
public class Vote {
	public static void main(String[] args) {
//		1번부터 5번까지의 반장후보 선거 결과
//		총 50명의 투표 인원이 5명에게 투표를 진행 하였다.
		int []mem = new int[5];
		char []memN= {'A','B','C','D','E'};
		int []vote = new int[50];
		Random ran = new Random();
		for(int i=0;i<50;i++) {
			vote[i] = ran.nextInt(5);
		}
		for(int i:vote)
			mem[i]++;
		System.out.println(Arrays.toString(mem));		
		System.out.println(Arrays.toString(memN));		
//		1. 가장 많이 투표를 받은 후보의 정보를 출력 하시오
//		2. 가장 적게 투표를 받은 후보의 정보를 출력 하시오
		int max=-1;
		int min=51;
		int maxM=-1;
		int minM=-1;
		for(int i=0;i<mem.length;i++) {
			if(mem[i]>max) {
				max = mem[i];				
				maxM=i+1;
			}
			if(mem[i]<min) {
				min = mem[i];
				minM=i+1;
			}
		}
		System.out.printf("최대득표자 : %d번 %d표\n최소득표자 : %d번 %d표\n",maxM,max,minM,min);
//		3. 투표 결과 가장 표를 가장 많이 받은 순으로 정렬 하여 출력 하고
		for(int i=0;i<mem.length;i++) {
			for(int j=i;j<mem.length;j++) {
				if(mem[i]<mem[j]) {
					int tmp = mem[i];
					mem[i]=mem[j];
					mem[j]=tmp;
					char tmp2 = memN[i];
					memN[i] = memN[j];
					memN[j]=tmp2;
				}
			}
		}
		System.out.printf("득표 %s\n",Arrays.toString(mem));		
		System.out.printf("득표자 %s\n\n",Arrays.toString(memN));	
//		4. 투표 결과 가장 표를 적게 받은 순으로 정렬 하여 출력 하시오
		for(int i=0;i<mem.length;i++) {
			for(int j=i;j<mem.length;j++) {
				if(mem[i]>mem[j]) {
					int tmp = mem[i];
					mem[i]=mem[j];
					mem[j]=tmp;
					char tmp2 = memN[i];
					memN[i] = memN[j];
					memN[j]=tmp2;
				}
			}
		}System.out.printf("득표 %s\n",Arrays.toString(mem));
		
		System.out.printf("득표자 %s\n",Arrays.toString(memN));
	}
}
