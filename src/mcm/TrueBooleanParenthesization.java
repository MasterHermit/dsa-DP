package mcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TrueBooleanParenthesization {
    private static HashMap<String,Integer>hm=new HashMap<>();
    static int noOfWays(String s,int i,int j,boolean exp){

        if(i>j)return 0;
        if(i==j){
            if(exp==true){
                if(s.charAt(i)=='t')return 1;
                else return  0;
            }else{
                if(s.charAt(i)=='f')return 1;
                else return 0;
            }
        }
        String key=i+" "+j+" "+exp;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        int ans=0;
        for(int k=i+1;k<j;k+=2){
            //System.out.println(i+"::"+k+"::"+j);
            int lt=noOfWays(s,i,k-1,true);
            int lf=noOfWays(s,i,k-1,false);
            int rt=noOfWays(s,k+1,j,true);
            int rf=noOfWays(s,k+1,j,false);

            if(s.charAt(k)=='&'){
                if(exp){
                    ans+=(lt*rt);
                }else{
                    ans+=(lt*rf)+(lf*rt)+(lf*rf);
                }
            }
            if(s.charAt(k)=='|'){
                if(exp){
                    ans+=(lt*rt)+(lt*rf)+(lf*rt);
                }else{
                    ans+=(lf*rf);
                }
            }
            if(s.charAt(k)=='^'){
                if(exp){
                    ans+=(rt*lf)+(rf*lt);
                }else{
                    ans+=(rt*lt)+(rf*lf);
                }
            }

        }
        hm.put(key,ans);
        return ans%10000007;
    }
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String ip=br.readLine().toLowerCase();
        int n=ip.length();

        System.out.println(noOfWays(ip,0,n-1,true));
    }
}
