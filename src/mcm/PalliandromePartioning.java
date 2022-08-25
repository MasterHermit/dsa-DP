package mcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalliandromePartioning {
    private static boolean isPalliandrome(String s,int i,int j){
        StringBuilder sb=new StringBuilder(s.substring(i,j+1));
        sb.reverse();
        return sb.toString().equals(s.substring(i,j+1));
    }

    private static  int partionCount(String s,int i,int j,int[][] mat){
        if(i>=j)return 0;
        if(isPalliandrome(s,i,j))return 0;
        if(mat[i][j]!=-1)return mat[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=1+ (mat[i][k]!=-1?mat[i][k]: partionCount(s,i,k,mat))+ (mat[k+1][j]!=-1?mat[k+1][j]:partionCount(s,k+1,j,mat));
            res=Math.min(res,temp);
        }
        mat[i][j]=res;
        return res;
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String ip=br.readLine();

        int n=ip.length();
        int[][] mat=new int[n+1][n+1];
        for(int[] row:mat) Arrays.fill(row,-1);

        System.out.println(partionCount(ip,0,n-1,mat));
    }
}
