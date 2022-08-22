package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestCommonSuperSequence {
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String io=br.readLine();
        String[] is=io.split(" ");
        String s1=is[0];
        String s2=is[1];
        System.out.println(commonSequenceLength(s1,s2,s1.length(),s2.length()));

    }

    private static int commonSequenceLength(String s1, String s2, int n, int m) {
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
        String op="";
        int i=n,j=m;
        while(i>0&& j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                op=s1.charAt(i-1)+op;
                i--;
                j--;

            }else{
                if(mat[i-1][j]>mat[i][j-1]){
                    op=s1.charAt(i-1)+op;
                    i--;
                }else{
                    op=s2.charAt(j-1)+op;
                    j--;
                }
            }
        }
        while(i>0){
            op=s1.charAt(i-1)+op;
            i--;
        }
        while(j>0){
            op=s2.charAt(j-1)+op;
            j--;
        }

        System.out.println(op);
        return (n+m)-mat[n][m];
    }
}
