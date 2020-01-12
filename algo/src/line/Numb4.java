package line;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Numb4 {
	public static void main(String[] args) {
		int[] inputList = { 1, -1, 3 };
		int result = solution(inputList);

		System.out.println(result);
	}

	public static int solution(int[] inputList) {
		Stack<Integer> positionHistory = new Stack<Integer>();
		Map<Integer, Integer> holeInPattern = new HashMap<Integer, Integer>();
		Map<Integer, Integer> holeOutPattern = new HashMap<Integer, Integer>();
		holeInPattern.put(5, 20);
		holeInPattern.put(10, 25);
		holeInPattern.put(22, 27);
		holeOutPattern.put(26, 22);
		holeOutPattern.put(24, 15);
		holeOutPattern.put(28, 0);
		holeOutPattern.put(19, 0);
		int answer = 0;
		int current = 0;
		positionHistory.add(current);
		for (int i = 0; i < inputList.length; i++) {
			int originInput = inputList[i];
			int input = originInput;
			while (input != 0) {
				System.out.println(current);
				if (input > 0) {
					if (originInput == input) {
						if (holeInPattern.containsKey(current)) {
							current = holeInPattern.get(current);
							positionHistory.add(current);
						}
						else {
							if (holeOutPattern.containsKey(current)) {
								current = holeOutPattern.get(current);
							}
							else {
								current++;
							}
							positionHistory.add(current);
						}
					}
					else {
						if (holeOutPattern.containsKey(current)) {
							current = holeOutPattern.get(current);
						}
						else {
							current++;
						}
						positionHistory.add(current);
					}
					input--;
					if (current == 0) {
						answer = current;
						return answer;
					}
				}
				else {
					current = positionHistory.pop();
					current = positionHistory.pop();

					positionHistory.add(current);

					input++;

					if (current == 0) {
						answer = current;
						return answer;
					}
				}
			}
		}

		answer = current;
		return answer;
	}
}
