import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static Integer[] arr;
    public static int[] diceExpectedValues;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static int searchBigExpected(){
        // int maxExpectedValue = Integer.MIN_VALUE;

        // System.out.println(t);
        int sum = 0;

        for (int j=3; j<=18; j++) {
            if(j < N)
                sum += arr[j] * diceExpectedValues[j];  
            else
                sum += -100 * diceExpectedValues[j];
        }

        int maxExpectedValue = sum;

        result.add(1);

        for(int t = 1; t<N; t++){
            
            for (int j=3; j<=18; j++) {
                if(t+j-1 < N)
                    sum -= arr[t+j-1] * diceExpectedValues[j];
                else
                    sum -= -100 * diceExpectedValues[j];
            }

            for (int j=3; j<=18; j++) {
                if(t+j < N)
                    sum += arr[t+j] * diceExpectedValues[j];
                else
                    sum += -100 * diceExpectedValues[j];
            }

            // System.out.println(sum);

            if(sum > maxExpectedValue){
                maxExpectedValue = sum;
                result.clear();
                result.add(t+1);
            }else if(sum == maxExpectedValue){
                result.add(t+1);
            }
        }

        return maxExpectedValue; // 위에 기대값을 count로 주었으므로 216은 곱하지 않음. 구하는 것은 실질적으로 경우의 수
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        // 주사위 확률표
        diceExpectedValues = new int[19];
        for(int i=1; i<=6; i++){
            for(int j=1; j<=6; j++){
                for (int k=1; k<=6; k++) {
                    diceExpectedValues[i+j+k]++;
                }
            }
        }


        // 양수라는 명시는 없으나, k+t가 범위를 넘을때라고 이야기하지 않고 'N을 넘을때'라 이야기 하였으므로, 
        // T는 양수가 맞는 것 같음.

        // int maxExpectedValue = Integer.MIN_VALUE;

        // System.out.println("Solve Expevted Value");
        // int expected = searchBigExpected(t);
            // System.out.println(expected);

        // System.out.println("Answer");
        System.out.println(searchBigExpected());

        for(Integer i : result){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}