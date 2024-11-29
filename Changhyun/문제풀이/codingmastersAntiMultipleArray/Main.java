import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    for(int l=0; l<N; l++){
                        if(i!=j && i!=k && i!=l
                        && j!=k && j != l
                        && k!=l){
                            if(arr[i] * arr[j] == arr[k] * arr[l]){
                                System.out.print("YES");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.print("NO");
    }
}