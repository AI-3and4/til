// don't place package name. 

import java.io.*;
import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        Scanner scanner = new Scanner(System.in); 

        int a = scanner.nextInt(); 

        int b = scanner.nextInt(); 
        
        int n = scanner.nextInt();
        
        System.out.print(a+(n-1)*b);

    }
}