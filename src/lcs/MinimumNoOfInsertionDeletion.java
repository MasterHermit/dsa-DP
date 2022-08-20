package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNoOfInsertionDeletion {
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String inputString=br.readLine();
        String[] inputArr=inputString.split(" ");
        String s1=inputArr[0];
        String s2=inputArr[1];

        System.out.println(minimumOperations(s1,s2,s1.length(),s2.length()));
    }

    private static int minimumOperations(String s1, String s2, int n, int m) {
        int[][] mat=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1]+1;

                }else{
                   mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }

        int insertion=m-mat[n][m];
        int deletion=n-mat[n][m];

        return insertion+deletion;
    }
}
