package programmers;

public class TargetNumber {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers,target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		answer=dfs(numbers,0,target,0);
		return answer;
	}
	public static int dfs(int [] n,int sum,int target, int idx) {
		if(idx==n.length) {
			if(sum==target) {
				return 1;
			}
			else {
				return 0;
			}
		}
		int result=0;
		result+=dfs(n,sum+1,target,idx+1);
		result+=dfs(n,sum-1,target,idx+1);
		return result;
	}
}
