import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int [] arr;
    public static int [] ans;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth) {
        if (depth == M) {
            for (int an : ans) {
                sb.append(an).append(' ');
            }
            sb.append('\n');
            return;
        }

        int before = 0;
        for (int i = 0; i < N; i++) {
            if (before != arr[i]) {
                ans[depth] = arr[i];
                before = arr[i];
                dfs(depth + 1);
            }
        }
    }
}