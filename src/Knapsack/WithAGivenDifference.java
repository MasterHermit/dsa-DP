package Knapsack;

import java.util.Scanner;

public class WithAGivenDifference {
    static int solve(int[] arr,int[][] mat,int n,int sum, int diff){
        int c=0;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = sc.nextInt();
        int[] arr =new int[n];

        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int sum=0;
        for(int i:arr)sum+=i;

        int[][] mat=new int[n+1][sum+1];

        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++)
            {
                if(i==0)mat[i][j]=0;
                if(j==0) mat[i][j]=1;

            }

        int s=(sum+diff)/2;

        System.out.println(solve(arr,mat,n,s,diff));

    }
}
