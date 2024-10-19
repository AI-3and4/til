
import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        int moneys[] = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int count = 0;
        for (int i:moneys){
            if(N/i < N){
                count += (N/i);
                N %= i;
            }

            if(N==1)
                break;
        }

        System.out.print(count);
    }
}