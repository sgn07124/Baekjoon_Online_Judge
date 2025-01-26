import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int [][] branch;
    static boolean [] visit;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        branch = new int[1001][1001];
        visit = new boolean[1001];

        // 인접 행렬 (양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            branch[x][y] = branch[y][x] = 1;
        }

        dfs(V);
        visit = new boolean[1001];
        sb.append('\n');
        bfs(V);
        System.out.println(sb);
    }
    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(' ');

        for (int i = 1; i <= N; i++) {
            if (branch[start][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        sb.append(start).append(' ');

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i < branch.length; i++) {
                if (branch[node][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    sb.append(i).append(' ');
                }
            }
        }
    }
}
