
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Chattering {

    private String solution(char[] input, int k) {

        StringBuilder answer = new StringBuilder();

        for (char c : input) {
            for (int i = 0; i < k; i++) {
                answer.append(c);
            }
        }
        return answer.toString();
    }


    public static void main(String[] args) throws IOException {
        Chattering main = new Chattering();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] n_and_k = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int n = n_and_k[0];
        int k = n_and_k[1];
        char[] input = new char[n];
        input = br.readLine().toCharArray();
        String answer = main.solution(input, k);
        bw.write(answer);
        bw.flush();

    }
}
