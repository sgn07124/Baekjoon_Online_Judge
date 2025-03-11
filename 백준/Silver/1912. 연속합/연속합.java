import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n + 1];
        int [] dp = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i - 1] = Math.max(arr[i], dp[i - 2] + arr[i]);
        }
        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}