// don't place package name. 

import java.io.*;
import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        Scanner scanner = new Scanner(System.in); 

        int x = scanner.nextInt(); 
        int y = scanner.nextInt(); 
        int z = scanner.nextInt(); 

        int a = z;
        int b = x;
        int c = y;

        if(Math.max(a,b) <= Math.max(b,c) && Math.max(b,c) <= Math.max(a,c) && Math.max(a,b) <= Math.max(b,c)){
            System.out.println("possible");
        }else{
            System.out.println("impossible");
        }

    }
}