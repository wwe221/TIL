package baekzoon;

import java.util.Scanner;

public class N14889 {
    public static int n;
    public static int[][] inputAry;
    public static boolean[] check;
    public static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        inputAry = new int[n+1][n+1];
		
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                inputAry[i][j] = sc.nextInt();
            }
        }

        check = new boolean[n+1];
		
        dfs(0,0);
        System.out.println(answer);
    }
	
    public static void dfs(int v, int depth) {
        if(depth == n/2) {
            makeTeam();
            return;
        }
		
        for(int i = v+1; i <= n; i++) {
            if(check[i])
                continue;
            check[i] = true;
            dfs(i, depth+1);
            check[i] = false;
        }
    }
	
    public static void makeTeam() {
        int[] a = new int[n/2+1];
        int[] b = new int[n/2+1];
        int aIndex = 1;
        int bIndex = 1;
        for(int i = 1; i <= n; i++) {
            if(check[i]) {
                a[aIndex++] = i;
            } else {
                b[bIndex++] = i;
            }
        }
        int aState = getState(a);
        int bState = getState(b);
        int diffState = Math.abs(aState - bState);
        answer = Math.min(answer, diffState);
    }
	
    public static int getState(int[] ary) {
        int result = 0;
        for(int i = 1; i <= n/2; i++) {
            for(int j = i + 1; j <= n/2; j++) {
                result += inputAry[ary[i]][ary[j]];
                result += inputAry[ary[j]][ary[i]];
            }
        }
        return result;
    }
}
