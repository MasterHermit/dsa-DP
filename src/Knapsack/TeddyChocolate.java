package Knapsack;

public class TeddyChocolate {
    static int maxChoco(int[] b,int[] c,int m,int n){
        if(n==0)return 0;
        if(m==0)return b[n-1]*c[n-1];

        if(b[n-1]<=m){
            return maxChoco(b,c,m-b[n-1],n-1);
        }else{
          return  b[n-1]*c[n-1]+maxChoco(b,c,m,n-1);
        }
    }
    public static void main(String[] args) {
        int[] b={1,2,3,4,5};
        int[] c={1,2,3,4,5};
        int n=b.length;
        int m=3;
        System.out.println(maxChoco(b,c,m,n));

    }
}
