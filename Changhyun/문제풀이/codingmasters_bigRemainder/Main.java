
import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        int r5 = input%5;
        int r7 = input%7;

        if(r5>r7)
            System.out.print(r5);
        else
            System.out.print(r7);
    }
}