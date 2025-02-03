import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] dp;
    static int [][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dp = new int[N][3];
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(paintCost(N - 1, 0), Math.min(paintCost(N - 1, 1), paintCost(N - 1, 2))));
    }

    private static int paintCost(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == 0) {  // R
                dp[n][0] = Math.min(paintCost(n - 1, 1), paintCost(n - 1, 2)) + cost[n][0];
            } else if (color == 1) {  // G
                dp[n][1] = Math.min(paintCost(n - 1, 0), paintCost(n - 1, 2)) + cost[n][1];
            } else {
                dp[n][2] = Math.min(paintCost(n - 1, 0), paintCost(n - 1, 1)) + cost[n][2];
            }
        }
        return dp[n][color];
    }
}
