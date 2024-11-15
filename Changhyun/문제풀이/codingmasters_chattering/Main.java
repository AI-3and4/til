import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputs = br.readLine().toLowerCase();
        int len = inputs.length();
        boolean[] isUsed = new boolean[26];
        for (int i =0; i<len; i++){
            isUsed[inputs.charAt(i)-'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!isUsed[i]) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}