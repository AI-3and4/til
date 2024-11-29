import java.io.*;
import java.util.ArrayList;

public class Main{
    public static double [][] regions = new double[2001][2001];
    public static ArrayList<double[]> nodeList = new ArrayList<>(2001);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        double goal_x, goal_y;
        goal_x = Long.parseLong(input[0]);
        goal_y = Long.parseLong(input[1]);

        nodeList.add(new double[] {goal_x, goal_y});

        int N = Integer.parseInt(br.readLine());

        Long x,y;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            x = Long.parseLong(input[0]);
            y = Long.parseLong(input[1]);
            nodeList.add(new double[] {x, y});
        }


        for (int i=0; i<N+1; i++){
            for (int j=0; j<N+1; j++) {
                if(i==j)
                    continue;
                regions[i][j] = Math.sqrt(Math.pow(nodeList.get(i)[0] - nodeList.get(j)[0],2) + Math.pow(nodeList.get(i)[1] - nodeList.get(j)[1],2));
                
            }
        }
    }
}