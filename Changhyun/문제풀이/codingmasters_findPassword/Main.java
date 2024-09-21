// don't place package name. 

import java.io.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        
        for(int i=0; i<s.length(); i++){
            
            System.out.print(s.charAt(i)); 
            if(s.charAt(i) == 'c')
                break;
        }

    }
}