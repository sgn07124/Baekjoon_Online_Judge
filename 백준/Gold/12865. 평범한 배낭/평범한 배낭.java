
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 물품의 수
        int K = Integer.parseInt(st.nextToken());  // 배낭 수용 최대 무게

        int [] W = new int[N + 1];
        int [] V = new int[N + 1];
        int [] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // K부터 탐색하여 담을 수 있는 최대 무게 한계치가 넘지 않을 때까지 반복
            for (int j = K; j - W[i] >= 0; j--) {
                // i 번째 물건에 대하여 W[i]의 합이 K를 넘으면 안됨 => K(최대 무게) - 누적된 W의 값 > 0 으로 중복 카운트 제거
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        System.out.println(dp[K]);
    }
}