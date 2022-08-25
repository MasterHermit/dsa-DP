package mcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class EggDroppingProblem {
    static  HashMap<String,Integer>hm=new HashMap<>();
    private static int minimumAttempts(int f,int e){
        if(f==0||f==1)return f;
        if(e==1)return f;
        String key=f+" "+e;
        if(hm.containsKey(key))return hm.get(key);
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int temp=1+Math.max(minimumAttempts(k-1,e-1),minimumAttempts(f-k,e));
            min=Math.min(min,temp);
        }
        hm.put(key,min);
        return min;
    }
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String ip=br.readLine();
        String[] ipa=ip.split(" ");
        int f=Integer.parseInt(ipa[0]);
        int e=Integer.parseInt(ipa[1]);

        System.out.println(minimumAttempts(f,e));
    }
}
