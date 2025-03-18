
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] graph;
    static boolean [] visit;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점
        M = Integer.parseInt(st.nextToken());  // 간선

        graph = new int[N][N];
        visit = new boolean[N];  // 정점 방문 여부

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                // 방문하지 않은 정점이라면?  bfs 실행하여 연결요소를 방문 처리하고 count++
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;  // 방문 처리

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 0; i < N; i++) {
                if (graph[tmp][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
