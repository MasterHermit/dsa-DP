import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiLineInput {

public static void main(String[] args) throws IOException {
	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	
	String str=br.readLine();
	String[] parts=str.split(" ");
	int n=Integer.parseInt(parts[0]);
	String name=parts[1];
	char ch=parts[2].charAt(0);
	
	System.out.println(n+" "+name+" "+ch);
	
}
}
