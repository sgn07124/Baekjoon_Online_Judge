import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] arr;
    static int [] ans;
    static boolean [] visit;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ans = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);
    }
    public static void dfs(int cnt){
        if(cnt == N) {
            int sum = 0;
            for(int i = 0; i < N-1; i++) {
                sum += Math.abs(ans[i] - ans[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visit[i]){
                ans[cnt] = arr[i];
                visit[i] = true;
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }
}