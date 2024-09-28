
import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");

        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        int[] fibonacci = new int[100];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i=2; i<20; i++){
            fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
        }
        int[] fibonaccifibonacci = new int[100];
        fibonaccifibonacci[0] = 1;
        fibonaccifibonacci[0] = 1;
        for(int i=0;)

        int tmp = 0;

        for(int i=a-1; i<b; i++){
            tmp = tmp+=fibonacci[i];
        }

        System.out.print(tmp);

    }
}