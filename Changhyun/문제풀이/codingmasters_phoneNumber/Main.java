import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split("-");
        if(inputs.length != 3 ||
            inputs[0].length() !=3 ||
            !"010".equals(inputs[0]) ||
            inputs[1].length() !=4 ||
            inputs[2].length() != 4
        )
        {
            System.out.print("invalid");
            return;
        }
        System.out.print("valid");
    }
}