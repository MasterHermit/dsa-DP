package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalliandromicSubSequence {
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String inputString=br.readLine();
        String[] inputArr=inputString.split(" ");
        String s1=inputArr[0];


        System.out.println(longestPalliandrome(s1,s1.length()));
    }

    private static int longestPalliandrome(String s1, int n) {
        int[][] mat=new int[n+1][n+1];
        StringBuilder s2=new StringBuilder(s1);
        s2.reverse();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else{
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[n][n];
    }
}
