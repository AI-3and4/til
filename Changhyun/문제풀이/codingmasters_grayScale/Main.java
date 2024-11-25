import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int r = Integer.parseInt(str.substring(1, 3),16);
        int g = Integer.parseInt(str.substring(3, 5),16);
        int b = Integer.parseInt(str.substring(5, 7),16);

        int gray = (int)Math.round((r + g + b) / 3.0);
        System.out.printf("#%02X%02X%02X", gray, gray, gray);
    }
}