import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [] dp;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        arr = new int[N+1];

        dp[0] = dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+1;
            arr[i] = i-1;
            if(i%2==0 && dp[i]>dp[i/2]+1){
                dp[i] = dp[i/2]+1;
                arr[i] = i/2;
            }
            if(i%3==0 && dp[i]>dp[i/3]+1){
                dp[i] = dp[i/3]+1;
                arr[i] = i/3;
            }
        }
        System.out.println(dp[N]);
        while (N > 0) {
            sb.append(N).append(" ");
            N = arr[N];
        }
        System.out.println(sb);
    }
}