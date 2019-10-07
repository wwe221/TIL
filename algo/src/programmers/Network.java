package programmers;

public class Network {
//https://programmers.co.kr/learn/courses/30/lessons/43162
	public static void main(String[] args) {
		int n = 3;
		int[][] com = { { 1, 1, 0, }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, com));
	}	
	static boolean[][] check;
	
	public static int solution(int n, int[][] com) {
		int answer=0;
		check = new boolean[n][n];
		for(int i=0;i<n;i++) {
			if(!check[i][i]) {
				dfs(com,i,n);
				answer++;
			}
		}
		return answer;
	}
	public static void dfs(int[][]com,int ind,int n) {
		for(int i = 0; i < n; i++) {			
			if(com[ind][i]==1 && !check[ind][i]) {
				check[ind][i] = true;
				check[i][ind] = true;
				dfs(com,i,n);
			}
		}
	}

}
