package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestRepeatingSubSequence {
    private static int longestLength(String s1,int n){
        String s2=s1;
        System.out.println(s2);
        int res=0;
        int[][] mat=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){

                if((s1.charAt(i-1)==s1.charAt(j-1)) && i!=j){
                    mat[i][j]=1+mat[i-1][j-1];


                }else{
                    mat[i][j]=Math.max(mat[i][j-1],mat[i-1][j]);
                }
            }
        }
        return mat[n][n];
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String io=br.readLine();

        System.out.println(longestLength(io,io.length()));
    }
}
