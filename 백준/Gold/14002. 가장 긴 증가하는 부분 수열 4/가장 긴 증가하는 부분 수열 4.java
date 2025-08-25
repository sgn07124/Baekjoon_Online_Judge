import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        int [] arr = new int[N];
        int [] dp = new int[N];
        Arrays.fill(dp, 1);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int lis = 1;
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }
        
        sb.append(lis).append("\n");
        
        //int cnt = 1;
        //for (int i = 0; i < N; i++) {
        //    if (dp[i] == cnt && cnt <= lis) {
        //        sb.append(arr[i]).append(" ");
        //        cnt++;
        //    }
        //}
        
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == lis) {
                stack.push(arr[i]);
                lis--;
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        
        System.out.println(sb);
    }
}