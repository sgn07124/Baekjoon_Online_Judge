
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int [] right_dp = new int[N];
        int [] left_dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            right_dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && right_dp[j] >= right_dp[i]) right_dp[i] = right_dp[j] + 1;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            left_dp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && left_dp[j] >= left_dp[i]) left_dp[i] = left_dp[j] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            result = Math.max(right_dp[i] + left_dp[i] - 1, result);
        }

        System.out.println(result);
    }
}
