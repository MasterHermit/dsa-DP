package mcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ScrammbledString {
    private static HashMap<String,Boolean>hm=new HashMap<>();
    private static boolean isScrambled(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        int n=s1.length();
        if(n==0)return false;
        if(s1.equals(s2))return true;

        String key=s1+" "+s2;
        if(hm.containsKey(key))return hm.get(key);

        boolean flag=false;
        for(int i=1;i<n;i++){
            if(((isScrambled(s1.substring(0,i),s2.substring(n-i,n)))&&isScrambled(s1.substring(i,n),s2.substring(0,n-i)))||((isScrambled(s1.substring(0,i),s2.substring(0,i)))&&(isScrambled(s1.substring(i,n),s2.substring(i,n))))){
                flag=true;
                break;
            };
        }
        hm.put(key,flag);
        return flag;
    }
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        String ip=br.readLine();
        String[] ipa=ip.split(" ");
        String s1=ipa[0];
        String s2=ipa[1];

        int n=s1.length();
        int m=s2.length();
        System.out.println(isScrambled(s1,s2));
    }
}
