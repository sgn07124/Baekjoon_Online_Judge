import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int [] arr = new int [n + 1];
        int [] dp = new int [n + 1];
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 이전의 값보다 크다면? 이전의 원소들 중 가장 큰 값 + 1
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}