package ws;

public class Grade {
	public int[] subs;
	private int length;
	public Grade(int[] subs) {
		this.subs = subs;
		this.length = this.subs.length;
	}
	public int sum() {
		int sum = 0;
		for (int i : subs)
			sum += i;
		return sum;
	}

	public double avg() {
		double avg = (double) this.sum() / (double) this.length;
		return avg;
	}

	public char grade() {
		char a;
		if (avg() > 90)
			a = 'A';
		else if (avg() > 80)
			a = 'B';
		else if (avg() > 70)
			a = 'C';
		else if (avg() > 60)
			a = 'D';
		else
			a = 'F';
		return a;
	}
	public int maxsub() {
		int max = -1;
		for (int i = 0; i < length; i++) {
			if (max < subs[i])
				max = subs[i];
		}
		return max;
	}

	public int minsub() {
		int min = 101;
		for (int i = 0; i < length; i++)
			if (min > subs[i])
				min = subs[i];
		return min;
	}
	public int[] asort() {
		int [] cpy = this.subs;
		int tmp;
		for (int i = 0; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
				if (cpy[i] > cpy[j]) {
					tmp = cpy[i];
					cpy[i] = cpy[j];
					cpy[j] = tmp;
				}
			}
		
		}
		return cpy;
	}
	public int[] dsort() {
		int [] cpy = this.subs;
		int tmp;
		for (int i = 0; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
				if (cpy[i] > cpy[j]) {
					tmp = cpy[i];
					cpy[i] = cpy[j];
					cpy[j] = tmp;
				}
			}
		}
		return cpy;
	}


}
