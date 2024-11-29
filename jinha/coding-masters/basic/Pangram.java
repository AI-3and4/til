import java.io.*;
import java.util.*;

public class Pangram {

    private String solution(String input) {

        // set에 알파벳 대문자 소문자 준비
        // 대문자
        Set<Character> set = new HashSet();

        // 소문자
        for (int i = 97; i < 123 ; i++) {
            set.add((char) i);
        }

         Set<Character> inputSet = new HashSet();
        char[] inputChar = input.toCharArray();
        for (int i = 0; i < inputChar.length; i++) {
            inputSet.add(Character.toLowerCase(inputChar[i]));
        }

        if (inputSet.containsAll(set)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
        Pangram main = new Pangram();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        String answer = main.solution(input);

        bw.write(answer);
        bw.flush();
    }

}