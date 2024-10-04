
import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        Integer[] arr = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for (Integer i : arr){
            if(i <= 160)
            {
                System.out.print("I " + i.toString());
                return;
            }
        }
        System.out.print("P");
    }
}