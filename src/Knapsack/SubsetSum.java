package Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {
static boolean subset(int n,int sum,int[] arr,boolean[][] d){
	for(int i=1;i<n+1;i++){
		for(int j=1;j<sum+1;j++)
		{

			
			 if(arr[i-1]<=j){
				 d[i][j]= d[i-1][j-arr[i-1]]||d[i-1][j];
			}
			else{
				d[i][j]=d[i-1][j];
			}
		}
	}
	return d[n][sum];
}

public static void main(String[] args) throws IOException {
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	int n=Integer.parseInt(br.readLine());
	int sum=Integer.parseInt(br.readLine());
	int[] arr=new int[n];
	for(int i=0;i<n;i++)arr[i]=Integer.parseInt(br.readLine());
	
	boolean[][] d=new boolean[n+1][sum+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=sum;j++){
			if(i==0)d[i][j]=false;
			if(j==0)d[i][j]=true;
		}
	}

	System.out.println(subset(n,sum,arr,d));
}
}
