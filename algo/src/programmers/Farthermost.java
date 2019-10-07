package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/49189
public class Farthermost {
	public static void main(String[] args) {
		int [][] edge ={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		solution(6, edge);
		
	}
	public static int solution(int n , int[][] edge) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<edge.length;i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<edge.length;i++) {
			int m = edge[i][0];
			int h = edge[i][1];
			list.get(m).add(h);
			list.get(h).add(m);
		}
		int [] d = new int[n+1];
		Arrays.fill(d, -1);
		d[1]=0;
		q.add(1);
		int u=0;
		while(q.size()>0) {
			u=q.poll();
			for(int e : list.get(u)) {
				if(d[e] == -1) {
					d[e] = d[u]+1;
					q.add(e);
				}
			}
		}
		for(int e: d) {
			System.out.println(e);
		}
		int cnt =0;
		int max = d[0];
		for(int i :d) {
			if(max <i) {
				max = i;
				cnt =1;			
			}else if(max==i) {
				cnt ++;
			}				
		}
		return cnt;
	}
}
