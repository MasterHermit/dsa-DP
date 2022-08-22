package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNoOfDeletionsToMakeAStringPallaindrome {
    static int deleteOperation(String s1,int n){
        StringBuilder s2=new StringBuilder(s1);
        s2.reverse();
        int[][] mat=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    mat[i][j]=1+mat[i-1][j-1];
                }else{
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }

        return n-mat[n][n];
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String ip=br.readLine();

        System.out.println(deleteOperation(ip,ip.length()));
    }
}
