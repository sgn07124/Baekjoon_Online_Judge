import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int [] result;
    public static boolean [] visit;
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        visit = new boolean[N];
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < N; i++) {
            result[depth] = i + 1;
            dfs(i, depth + 1);
        }
    }
}