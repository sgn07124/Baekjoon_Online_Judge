
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [] answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];

        dfs(1, 0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int at, int depth) throws IOException {
        if (depth == M) {
            for (int i : answer) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
            answer[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}