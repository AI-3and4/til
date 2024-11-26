import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TrainandFly {

    public long calculateFlyDistance(int X, int Y, int Z) {
        if (X <= 0 || Y <= 0 || Z <= 0) {
            throw new IllegalArgumentException("입력값은 모두 양수여야 합니다.");
        }

        double totalSpeed = 2.0 * Y; // 두 기차의 합쳐진 속도 (double 형 변환)
        double collisionTime = X / totalSpeed; // 충돌까지 걸리는 시간 (소수 포함)
        long flyDistance = (long) (collisionTime * Z); // 파리가 이동한 거리 (소수점 제거)
        return flyDistance;
    }

    public static void main(String[] args) throws IOException {
        TrainandFly main = new TrainandFly();
        // BufferedReader와 BufferedWriter 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 읽기
        String input = br.readLine();
        String[] parts = input.split(" ");
        int X = Integer.parseInt(parts[0]);
        int Y = Integer.parseInt(parts[1]);
        int Z = Integer.parseInt(parts[2]);

        // 계산 수행
        try {
            long result = main.calculateFlyDistance(X, Y, Z);
            // 결과 출력
            bw.write(String.valueOf(result));
            bw.newLine(); // 개행
        } catch (IllegalArgumentException e) {
            bw.write("입력값은 모두 양수여야 합니다.");
            bw.newLine();
        }

        // 자원 닫기
        br.close();
        bw.close();
    }

}
