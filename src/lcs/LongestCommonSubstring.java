package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class LongestCommonSubstring {
    static int solve(String s1,String s2,int n,int m,int[][] mat){
        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    mat[i][j]=1+mat[i-1][j-1];
                    res=Integer.max(res,mat[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String ip = br.readLine();
        String ipa[] = ip.split(" ");
        String s1 = ipa[0];
        String s2 = ipa[1];

        int n = s1.length();
        int m = s2.length();
        System.out.println(s1+" "+s2);
        int[][] mat = new int[n + 1][m + 1];

        System.out.println(solve(s1, s2, n, m, mat));

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++) {
                System.out.print(mat[i][j] + " ");
            }
        System.out.println();
    }


    }
}
