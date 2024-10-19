import java.io.*;
import java.util.*;

public class Main{
    public static Boolean [][] regions = new Boolean[100][100];

    public void fill(int x, int y){
        Queue<int[][]> = new Queue<int[][]>();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int m,n,k;
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        int x1,y1,x2,y2;
        while(k-- > 0){
            input = br.readLine().split(" ");
            x1 = Integer.parseInt(input[0]);
            y1 = Integer.parseInt(input[1]);
            x2 = Integer.parseInt(input[2]);
            y2 = Integer.parseInt(input[3]);

            for(int i=x1; i<x2; i++){
                for(int j=y1; j<y2; j++){
                    regions[i][j] = true;
                }
            }
        }
    }
}