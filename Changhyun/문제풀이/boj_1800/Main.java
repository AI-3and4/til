import java.io.*;
import java.util.*;

public class Main{
    ArrayList<int[]>[] graph = new ArrayList[1001];
    int[] dist = new int[1001];
    int[] navi = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        for(int i=0; i<p; i++){
            input = br.readLine().split(" ");
            
        }
    }
}