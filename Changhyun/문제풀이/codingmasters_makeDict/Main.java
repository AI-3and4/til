// don't place package name. 

import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Comparator<String> compare = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                int diff = a.length() - b.length();
                if(diff == 0){
                    return a.compareTo(b);
                }
                return diff;
            }
        };

        Set<String> dict = new TreeSet<>(compare);

        for (int i=0; i<n; i++) {
            dict.add(bf.readLine());
        }

        for (String i : dict) {
            System.out.println(i);
        }
    }
}
