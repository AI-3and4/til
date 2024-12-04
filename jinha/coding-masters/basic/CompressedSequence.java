import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class CompressedSequence {

    /*
    10진법 정수 123(= 1 × 10² + 2 × 10¹ + 3 × 10⁰)은
    12진법으로 A3(= A × 12¹ + 3 × 12⁰)으로 표기하고,
     40진법으로 33(= 3 × 40¹ + 3 × 40⁰)으로 표기합니다.
     47진법 2 x 47제곱 + q x 47 + k


     10진법 0부터 9까지는 똑같이 0부터 9로, 10부터 35까지는 A부터 Z까지의 대문자 알파벳으로,
     36부터 62까지는 a부터 z까지의 소문자 알파벳을 사용합니다.
     예를 들어 입력 파일 1 2 30 123을 12진법으로 표기하면 1 2 26 A3이 되어 파일의 크기가 9로 줄어듭니다.
     */

    // 4 9
    // 1 2 30 123

    public int solution(int[] nm, String[] files) {

        // 입력받은 숫자를
        // 10진법으로 바꿔서 글자수 셌다가
        // 11 글자수 세서 줄어들었는지 확인, 그게 m이 되었는지 확인
        // 12, 그게m
        // m이 되었으면 while문 종료

        // 1) 각 진법으로 각 숫자 바꾸기 : 이 로직을 모르겠음 -> Integer클래스가 알아서 해줬음
        // 2) 바꾼 숫자 사이사이에 숫자 개수 -1만큼의 공백 넣기
        // 3) 글자수 세기

        int n = nm[0];
        int m = nm[1];

        int wordCount = 0;
//        for (String file : files) {
//            wordCount += file.length() + 1;
//        }
        for (String file : files) {
            wordCount += file.length();
        }
        wordCount += (n - 1); // 공백 크기 추가

        if (wordCount <= m) {
            return 10;
        }

        for(int i = 11; i < 63; i++) {
            int nextWordCount = 0;

//            for (String file : files) {
//                String converted = Integer.toString(Integer.parseInt(file), i);
//                nextWordCount += converted.length() + 1;
//            }
//            nextWordCount -= 1;

            for (String file : files) {
                // 파일을 해당 진법으로 변환 후 길이 합산
                BigInteger number = new BigInteger(file, 10);
                String converted = BaseConverter.toBase(number, i);
//                String converted = Integer.toString(Integer.parseInt(file), i);
                nextWordCount += converted.length();
            }
            nextWordCount += (n - 1); // 공백 크기 추가

            if (nextWordCount <= m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        CompressedSequence main = new CompressedSequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] files = Stream.of(br.readLine()
//                .split(" "))
//            .mapToInt(Integer::parseInt)
//            .toArray();
        String[] files = br.readLine().split(" ");
        int answer = main.solution(nm, files);
        bw.write(answer + "\n");
        bw.flush();
    }
}


class BaseConverter {
    private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String file = "100000"; // 10진수 입력값
        int base = 47;          // 변환할 진법

        // 10진수로 읽기
        BigInteger number = new BigInteger(file, 10);
        // base 진법으로 변환
        String converted = toBase(number, base);

        // 결과 출력
        System.out.println("Original value in decimal: " + file);
        System.out.println("Converted value in base " + base + ": " + converted);
    }

    public static String toBase(BigInteger number, int base) {
        if (base < 2 || base > 62) {
            throw new IllegalArgumentException("Base must be between 2 and 62");
        }

        StringBuilder result = new StringBuilder();
        BigInteger baseBigInt = BigInteger.valueOf(base);

        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divmod = number.divideAndRemainder(baseBigInt);
            int mok = divmod[0].intValue();
            int nameoji = divmod[1].intValue();
            result.insert(0, DIGITS.charAt(divmod[1].intValue()));
            number = divmod[0];
        }
        return result.toString();
    }
}