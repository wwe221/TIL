package programmers;

//https://programmers.co.kr/learn/courses/30/lessons/12905
public class BiggestSquare {

	public static void main(String[] args) {
		int[][] a = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(solution2(a));

	}

	static public int solution(int[][] board) {
		int answer = 0;
		int n = board[0].length;
		int m = board.length;
		int size = 1;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = check2(board, i, j);
				if (tmp > max)
					max = tmp;
			}
		}
		answer = max;
		return answer;
	}

	static public int solution2(int[][] board) {
		int answer = 0;
		int[][] arr = new int[board.length + 1][board[0].length + 1];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1)
					arr[i + 1][j + 1] = 1;
				else
					arr[i + 1][j + 1] = 0;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					int min = Math.min(arr[i - 1][j], arr[i][j - 1]);
					min = Math.min(min, arr[i - 1][j - 1]);
					arr[i][j] = min + 1;
					answer = Math.max(answer, arr[i][j]);
				}
			}
		}
		return answer * answer;
	}

	static public int check2(int[][] map, int n, int m) {
		int ret = 0;
		int x = map[0].length;
		int y = map.length;
		boolean flag = true;
		int size = 1;
		int max = 0;
		while (flag) {
			int cnt = 0;
			if (x < m + size || y < n + size)
				break;
			for (int i = n; i < n + size; i++) {
				for (int j = m; j < m + size; j++) {
					if (map[i][j] == 1)
						cnt++;
				}
			}
			if (cnt == size * size) {
				if (cnt > max)
					max = cnt;
			}
			size++;
		}
		ret = max;
		return ret;
	}
}
