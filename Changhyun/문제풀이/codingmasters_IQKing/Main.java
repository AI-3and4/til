
import java.io.*;
import java.util.*;

// don't change 'Main' class name and  'public' accessor. 

public class Main {

    public static void main(String[] args) throws IOException { 
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Map.Entry<Integer, String>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] input = bf.readLine().split(" ");
            int iq = Integer.parseInt(input[1]);
            String name = input[0];

            list.add(new AbstractMap.SimpleEntry<>(iq,name));
        }

        list.sort((e1,e2) -> e2.getKey().compareTo(e1.getKey()));

        for(int i=0; i<3; i++){
            System.out.println(list.get(i).getValue());
        }
    }
}