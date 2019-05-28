package set;

import java.util.ArrayList;
import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random ran = new Random();		
		while(true) {
			list.add(ran.nextInt(45)+1);
			if(list.size()>=10)
				break;
		}
		for(Integer i :list) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println();
		list.sort(null);
		for(Integer i :list) {
			System.out.println(i);
		}
		

	}

}
