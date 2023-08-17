import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp[x] : x위치까지 갈 수 있는 최소 점프 횟수


public class Main {
    private static final int MAX = 1001;

    public void problem17086() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] maze = new int[N+1];
        for (int i = 1; i <= N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());  // [0, 1, 2, 0, 1, 3, 2, 1, 5, 4, 2]
        }
        //System.out.println(Arrays.toString(maze));

        int [] dp = new int[N+1];
        Arrays.fill(dp, MAX);  // N : (1 ≤ N ≤ 1,000)  dp의 값을 MAX로 초기화
        dp[1] = 0;  // [1001, 0, 1001, 1001, 1001, 1001, 1001, 1001, 1001, 1001, 1001]
        //System.out.println(Arrays.toString(dp));
        for (int i = 1; i<= N; i++) {
            //System.out.println("dp[i] : " + dp[i]);
            for (int j = i+1; j < i+1+maze[i]; j++) {  // maze[i]의 구간만큼 이동
                if (j > N) break;  // 배열 넘기면 끝!
                dp[j] = Math.min(dp[i]+1, dp[j]);  // 비교해보면 최솟값이 들어가므로 dp[1](i=1) 을 시작으로해서 최솟값이 dp[j]에 저장됨
                //System.out.println("dp : " + Arrays.toString(dp));
            }
        }
        if (dp[N] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }

    }
    public static void main(String[] args) throws Exception {
        new Main().problem17086();
    }
}