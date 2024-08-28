import java.io.*;
import java.util.StringTokenizer;

// N과 M(1)
public class Main {

    static int N, M;
    static int [] arr;
    static boolean [] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth+1);
                visited[i] = false;
            }
        }
    }

}