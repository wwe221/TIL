package calc;

public class Calc {
	private int[] data;

	public Calc() {

	}

	public Calc(int[] data) {
		this.data = data;
	}


	// 1. Sum
	public int sum() {
		int sum = 0;
		for (int i : data)
			sum += i;
		return sum;
	}

	public double avg() {
		int sum = this.sum();
		int l = this.data.length;
		return (double) (sum) /(double) l;
	}

	// 2. Sort Ascending
	public int[] asort() {
		int[] cpy = this.data;
		int l = cpy.length;
		int tmp;
		for (int i = 0; i < l-1; i++) {
			for (int j = i+1; j < l; j++) {
				if (cpy[i] > cpy[j]) {
					tmp = cpy[i];
					cpy[i] = cpy[j];
					cpy[j] = tmp;
				}
			}
		}
		return cpy;
	}

	// 3. Sort Desc
	public int[] dsort() {
		int[] cpy = this.data;
		int l = cpy.length;
		int tmp;
		for (int i = 0; i < l - 1; i++) {
			for (int j = i+1; j < l ; j++) {
				if (cpy[i] < cpy[j]) {
					tmp = cpy[i];
					cpy[i] = cpy[j];
					cpy[j] = tmp;
				}
			}
		}

		return cpy;
	}

}
