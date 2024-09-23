
import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int[] arr = new int[input.length];
        
        for(int i=0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(arr);
        
        System.out.println(arr[2]);
    }
}