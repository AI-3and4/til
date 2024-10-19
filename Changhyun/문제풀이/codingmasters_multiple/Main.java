
import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();

        Integer[] arr = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(arr, Comparator.reverseOrder());

        int tmp = 0;
        int zeroCount = 0;

        for (int i : arr){
            if(i == 0)
                zeroCount++;
            tmp += i;
        }

        // System.out.print(tmp);

        if(tmp % 3 == 0 && zeroCount>=2){
            if(zeroCount == arr.length){
                System.out.print(0);
            }else{
                for(int i:arr){
                    System.out.print(i);
                }
            }
        }else{
            System.out.print(-1);
        }
    }
}