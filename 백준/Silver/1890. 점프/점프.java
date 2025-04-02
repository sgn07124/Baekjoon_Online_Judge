import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int [][] map = new int[N][N];
        long [][] dp = new long[N][N];  // dp 배열은 long으로 선언 

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int jump = map[i][j];
                if (jump == 0) break;  // 종료 지점
                if (j + jump < N) dp[i][j + jump] += dp[i][j];  // 오른쪽 점프
                if (i + jump < N) dp[i + jump][j] += dp[i][j];  // 아래쪽 점프
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}