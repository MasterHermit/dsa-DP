package Knapsack;

import java.util.Scanner;

public class MinimumDifference {

    static int solve(int[] arr,int n,int sum,boolean[][] mat){
        int res= Integer.MAX_VALUE;

            for(int j=1;j<=sum/2;j++){
                if(mat[n][j]==true){
                    res=Math.min(res,sum-2*j);
                }
            }
            return res;
    }
    static int solve(int[] arr,int n,int sum,int diff){
        boolean[][] mat=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++){
                if(i==0)mat[i][j]=false;
                if(j==0) mat[i][j]=true;
            }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    mat[i][j]=mat[i-1][j-arr[i-1]]||mat[i-1][j];
                }
                else{
                    mat[i][j]=mat[i-1][j];
                }
            }
        }

       return solve(arr,n,sum,mat);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int diff=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int sum=0;
        for(int i:arr)sum+=i;

        System.out.println(solve(arr,n,sum,diff));
    }
}
