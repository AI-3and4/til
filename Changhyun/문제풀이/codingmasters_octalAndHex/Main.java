
import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        System.out.printf("%s %s", Integer.toOctalString(n), Integer.toHexString(n).toUpperCase());
    }
}