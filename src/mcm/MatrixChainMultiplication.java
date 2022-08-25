package mcm;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int[][] mat=new int[n+1][n+1];
        for(int[] i:mat){
            Arrays.fill(i,-1);
        }

        System.out.println(minimumMultiplication(arr,1,n-1,mat));
    }

    private static int minimumMultiplication(int[] arr, int i, int j,int[][] mat) {
        if(i>=j)return 0;
       int res=Integer.MAX_VALUE;
        if(mat[i][j]!=-1)return mat[i][j];
        for(int k=i;k<=j-1;k++){
            int temp=minimumMultiplication(arr,i,k,mat)+minimumMultiplication(arr,k+1,j,mat)+arr[i-1]*arr[k]*arr[j];
           res=Math.min(res,temp);
        }
        mat[i][j]=res;
        return res;
    }
}
