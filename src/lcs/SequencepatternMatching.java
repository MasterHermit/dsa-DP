package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequencepatternMatching {
    private static boolean isPatternPresent(String s1,String s2,int n,int m){
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
        return s1.length()==mat[n][m];

    }
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String ip=br.readLine();
        String[] ipArr=ip.split(" ");
        String s1=ipArr[0];
        String s2=ipArr[1];

        System.out.println(isPatternPresent(s1,s2,s1.length(),s2.length()));
    }

}
