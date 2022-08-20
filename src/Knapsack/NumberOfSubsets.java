package Knapsack;

import java.util.Scanner;

public class NumberOfSubsets {
    static int solve(int[] arr,int[][] mat,int n,int sum){
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    mat[i][j]=mat[i-1][j-arr[i-1]]+mat[i-1][j];
                }else{
                    mat[i][j]=mat[i-1][j];
                }
            }

        return mat[n][sum];
    }
    static  int solve(int[] arr,int n,int sum){
        int[][] mat=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++){
                if(i==0)mat[i][j]=0;
                if(j==0)mat[i][j]=1;
            }

        return solve(arr,mat,n,sum);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        System.out.println(solve(arr,n,sum));

    }
}
