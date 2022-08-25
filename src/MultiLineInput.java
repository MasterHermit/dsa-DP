import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiLineInput {

public static void main(String[] args) throws IOException {
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	
	String str=br.readLine();
	String[] parts=str.split(";");
	int n=Integer.parseInt(parts[0]);
	int m=Integer.parseInt(parts[1]);
	int[] x=new int[(parts[2].length()/2)+1];
	int[] y=new int[(parts[3].length()/2)+1];
	parts[2]=parts[2].replace(",","");


	
	System.out.println(n+" "+m);

	for(int i=0;i<x.length;i++){
		x[i]=(parts[2].charAt(i)-'0');

	}
	for(int i:x) System.out.print(i+" ");
	
}
}
