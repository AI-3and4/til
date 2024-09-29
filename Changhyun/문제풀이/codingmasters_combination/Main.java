
import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    static long combination(int n, int r){
        long result = 1;
        long tmp = 1;

        for(int i=n; i>n-r; i--){
            result*=i;
            result /= tmp++;
            // System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        System.out.println(combination(a,b));
        
    }
}