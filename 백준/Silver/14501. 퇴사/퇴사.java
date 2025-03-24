import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] t = new int[N];
        int [] p = new int[N];
        int [] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());  // 상담을 완료하는데 걸리는 시간
            p[i] = Integer.parseInt(st.nextToken());  // 상담 금액
        }

        for (int i = 0; i < N; i++) {
            if (i + t[i] <= N) {
                // 날짜가 초과되지 않으면서 해당 날짜에 번 돈을 계산
                // dp[i + t[i]] 값(이전까지의 최대 수익)과 dp[i] + p[i] 값(현재 상담을 선택했을 때의 수익) 중 최댓값으로 갱신
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }

            // 오늘 일한 양을 다음 날에 누적
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}