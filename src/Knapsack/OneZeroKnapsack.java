package Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneZeroKnapsack {

static int knapsack(int n,int w,int[] weight,int[] value){
	int[][] d=new int[n+1][w+1];
	for(int i=0;i<n+1;i++)
		for(int j=0;j<w+1;j++){
			if(i==0||j==0)d[i][j]=0;
			else if(weight[i-1]<=w){
				d[i][j]=Math.max(value[i-1]+d[i-1][w-weight[i-1]],d[i-1][j]);
			}
			else{
				d[i][j]=d[i-1][j];
			}
		}
return d[n][w];

}



public static void main(String[] args) throws IOException {
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	
	int  n=Integer.parseInt(br.readLine());
	int wt=Integer.parseInt(br.readLine());
	
	int weight[]=new int[n];
	int value[]=new int[n];
	
	for(int i=0;i<n;i++)weight[i]=Integer.parseInt(br.readLine());
	
	for(int i=0;i<n;i++)value[i]=Integer.parseInt(br.readLine());
	
	
	
	OneZeroKnapsack ob=new OneZeroKnapsack();
	int val=ob.knapsack(n,wt,weight,value);
	System.out.println(val);
	
}
}
