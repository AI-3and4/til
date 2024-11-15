// don't place package name. 

import java.io.*;
import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    final static int mod_num = 1000000007;

    private static void multiMatrix(long[][] a, long[][] b){
        long[][] tmp = new long[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                tmp[i][j] = 0;

                for(int k=0; k<4; k++){
                    tmp[i][j] += (a[i][k] * b[k][j]);
                }

                tmp[i][j] %= mod_num;
            }
        }

       for(int i=0; i<4; i++)
            System.arraycopy(tmp[i], 0, b[i], 0, 4);
    }
    public static void main(String[] args) throws IOException { 

        Scanner scanner = new Scanner(System.in); 

        long n = scanner.nextLong();

        // 일단 dp. 동전 냄새남.
        // 주사위 숫자 이상의 친구는 "N-주사위숫자 + 주사위숫자"로 표현이 가능함.
        // 앞에 경우를 기억해 놓으면, 다 더하여서 경우의 수를 구할 수 있음.
        // 때문에, 앞에 네개 더하는게 점화식이라 할 수 있음.
        // 10^12면 다 저장하지말고 앞으로 밀며 가야할듯.

        // long[] arr = new long[5];
        // arr[0] = 1;
        // arr[1] = 2; // 11, 2
        // arr[2] = 4;
        // arr[3] = 8; // 4, 13,31,22,112,121,211,1111

        // for (int i=5; i<=n; i++) {
        //     arr[4] = (arr[3] + arr[2] + arr[1] + arr[0])%mod_num;
        //     arr[0] = arr[1];
        //     arr[1] = arr[2];
        //     arr[2] = arr[3];
        //     arr[3] = arr[4];
        // }
        
        // if(n < 5)
        //     System.out.print(arr[(int)(n-1)]);
        // else
        //     System.out.print(arr[4]);

        // 위에건 안됨. 엄청 오래걸림. 10^12를 무시하지 말것.
        // 피보나치랑 엄청 비슷함. 피보나치 행렬식 있지 않았나?
        // 나무위키를 찾아보면.
        /*
            [1 1
             1 0]
             *
            [f(n+1) f(n)
             f(n) f(n-1)]
             = [f(n+2) f(n+1)
                f(n+1) f(n)]

            그리고 

            [1 1
             1 0]
             =
             [f(2) f(1)
             f(1) f(0)]
             이니까
            A
            =[1 1
             1 0] 
            이라 치면
            A^n = 
            [f(n+1) f(n)
             f(n) f(n-1)]

            ==============================

             0 1 2 4 8 15 29 ...
            이건 앞에 네개 더하는 피보나치임.
            따라서 위 식을 지금 상황에 대해 확장해보면 =>

            [1 1 1 1
             1 0 0 0
             0 1 0 0
             0 0 1 0]
             =A이라 하면
            A^n 을 해서 n번째 값을 알아낼 수 있음!

            이게 왜 빨랐었냐면, 행렬 곱셈을 분할정복하는 방법이 있었음. 그거 쓰면 log N이 가능.

             n이 짝수면 ,
             A^n = A^(n/2) * A^(n/2)
             홀수면,
             A^n = A * A^(n-1)
            로 나눠 계산이 가능함. 계산함.

            이때, 행렬 A를 A^2, A^4, ... 식으로 거듭제곱하면서 밀면
            log N의 복잡도를 보장하게 됨.

            초기에 결과를 저장할 단위 행렬 result을 둠.
            승수가 *2씩 올라가니까, n을 /2씩 낮추면 log N만에 A^n근처에 도달할 수 있음.
            나누다가 n이 1이 되면 다 온거임.

            n이 홀수면 result에 현재 A를 곱해서 A^n 만들거임(결과에 누적). 이때 n이 홀수니까 n-1은 무조건 짝수.
        */

        long[][] stan = new long[][]{{1,1,1,1},{1,0,0,0},{0,1,0,0},{0,0,1,0}};
        long[][] result = new long[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,1,0}};

        while(n > 0){
            if(n%2 == 1) // n홀수인 경우
                multiMatrix(stan, result);
            multiMatrix(stan, stan); // 일반항 제곱. 2,4,8,...으로 쭉 갈거임. 제곱으로 건너뛰니까 n을 2로 나누며 갈 수 있음.
            n/=2;
        }

        System.out.print(result[0][0]);
    }
}