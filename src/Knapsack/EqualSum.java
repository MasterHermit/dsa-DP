package Knapsack;

import java.util.Scanner;

public class EqualSum {
    static boolean solve(int[] arr,boolean[][] mat,int n,int sum){
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    mat[i][j]=mat[i-1][j-arr[i-1]]||mat[i-1][j];
                }else{
                    mat[i][j]=mat[i-1][j];
                }
            }

        return mat[n][sum];
    }

    public static boolean solve(int[] arr,int sum,int n){
        boolean[][] mat=new boolean[n+1][(sum/2)+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<(sum/2)+1;j++){
                if(i==0)mat[i][j]=false;
                if(j==0)mat[i][j]=true;
            }
        if(sum%2!=0)return false;
        else {
          return   solve(arr,mat,n,sum/2);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int sum=0;
        for(int i:arr)sum+=i;

        System.out.print(solve(arr,sum,n));
    }
}
