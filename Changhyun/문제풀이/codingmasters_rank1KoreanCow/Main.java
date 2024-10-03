
import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(bf.readLine());

        if(weight >= 200){
            System.out.print('A');
        }else if(weight >= 180)
            System.out.print('B');
        else if(weight >= 150)
            System.out.print('C');
        else
            System.out.print('D');
    }
}