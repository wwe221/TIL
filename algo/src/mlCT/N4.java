package mlCT;

public class N4 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7 };
		System.out.println(solution(a));
	}

	public static int solution(int[] bricks) {
		int[] right = bricks.clone();
		int[] left = bricks.clone();
		int[] answerList = new int[bricks.length];

		int temp;
		int length = bricks.length;
		temp = right[0];
		for (int i = 1; i < length; i++) {
			if (right[i] > temp) {
				temp = right[i];
			} else if (right[i] < temp) {
				right[i] = temp;
			}
		}
		temp = left[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			if (left[i] > temp)
				temp = left[i];
			else if (left[i] < temp)
				left[i] = temp;
		}
		for (int i = 0; i < length; i++) {
			if (right[i] < left[i])
				answerList[i] = right[i];
			else
				answerList[i] = left[i];
		}
		int answer = 0;
		for (int i = 0; i < length; i++) {
			answer += answerList[i] - bricks[i];
		}
		return answer;
	}

}
