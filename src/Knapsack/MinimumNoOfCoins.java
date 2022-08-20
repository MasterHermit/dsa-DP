package Knapsack;

import java.util.Scanner;

public class MinimumNoOfCoins {
    static int solve(int[] arr,int[][] mat,int n,int sum){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    mat[i][j]=Math.min(1+mat[i][j-arr[i-1]],mat[i-1][j]);
                }else{
                    mat[i][j]=mat[i-1][j];
                }
            }
        }
        return mat[n][sum]==sum+1?-1:mat[n][sum];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int[][] mat =new int[n+1][sum+1];

        for(int i=0;i<=n;i++)
            for(int j =0;j<=sum;j++){
                if(j==0)mat[i][j]=0;
                if(i==0)mat[i][j]=sum+1;

            }
//        for(int j=1;j<=sum;j++){
//            if(j%arr[0]==0){
//                mat[1][j]=j/arr[0];
//            }else{
//                mat[1][j]=sum+1;
//            }
//        }
        System.out.println(solve(arr,mat,n,sum));
    }
}
