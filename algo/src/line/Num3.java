package line;

class Num3 {
    public int solution(int[] hList) {
           int[] right = hList.clone();
        int[] left = hList.clone();
        int[] answerList = new int[hList.length];
        
        int temp;
        int length = hList.length;
        temp  = right[0];
        for(int i=1;i<length;i++) {
           if(right[i] > temp) {
              temp = right[i];
           }
           else if(right[i] < temp) {
              right[i] = temp;
           }
        }
        temp = left[length-1];
        for(int i= length-2;i>=0;i--) {
           if(left[i]>temp) temp = left[i];
           else if(left[i]<temp) left[i] = temp;
        }
        for(int i=0;i<length;i++) {
           if(right[i] < left[i]) answerList[i] = right[i];
           else answerList[i] = left[i];
        }
        int answer = 0;
        for(int i=0;i<length;i++) {
           answer += answerList[i] - hList[i];
        }
        return answer;
    }
}
