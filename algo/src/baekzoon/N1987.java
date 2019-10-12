package baekzoon;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1987
//¹Ì¿Ï
public class N1987 {
	static int r;
	static int c;
	static char[][] map;
	static char[][] map2;
	static int []dx= {1,-1,0,0};
	static int []dy= {0,0,1,-1};
	static boolean [] visit;
	static int cnt=0;
	static int ans =0;
	static ArrayList<Character> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r= sc.nextInt();
		c= sc.nextInt();
		visit= new boolean[26];
		map = new char[r][c];
		for(int i=0;i<r;i++) {
			String a = sc.next();
			map[i]=a.toCharArray();
		}
		list.add(map[0][0]);
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}		
		dfs(0,0);
		System.out.println(ans);
	}
	static void dfs(int x,int y) {
		list.add(map[x][y]);
		visit[map[x][y]-'A']=true;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if( nx>=0 && nx< r && ny >=0 && ny<c) {
				if(visit[map[nx][ny]]) {									
					ans = Math.max(++cnt,ans);
					dfs(nx,ny);
				}
			}
		}
		--cnt;
		visit[map[x][y]-'A']=false;
	}
}
