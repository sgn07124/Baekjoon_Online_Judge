import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];  // 꼭대기 값
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];  // 왼쪽 라인
            dp[i][i] += dp[i - 1][i - 1] + triangle[i][i];  // 오른쪽 라인
        }
        
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];  // 왼쪽 대각선 위의 값과 오른쪽 대각선 위의 값 중 큰 값을 더하여 저장
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp[n - 1][i]) max = dp[n - 1][i];
        }
        System.out.println(max);
    }
}