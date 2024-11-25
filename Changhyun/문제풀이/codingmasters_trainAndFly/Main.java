import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        float x = Float.parseFloat(inputs[0]);
        float y = Float.parseFloat(inputs[1]);
        float z = Float.parseFloat(inputs[2]);
        
        System.out.println((int)((x/(2*y))*z));
    }
}