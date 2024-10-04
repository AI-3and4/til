
import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Integer[] arr = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int a = arr[0];
        int b = arr[1];
        int n = arr[2];

        int words = 0;
        int count = 0;
        while(words < n-b){
            words+=(a-b);
            count++;
        }
        System.out.print(count);
    }
}