import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;  // T: 테스트 케이스 | M: 가로 길이 | N: 세로 길이 | K: 배추 위치 개수
    static int [][] graph;
    static boolean [][] visited;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int count;  // 최소 날짜
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 가로
            M = Integer.parseInt(st.nextToken());  // 세로
            K = Integer.parseInt(st.nextToken());  // 배추 개수
            graph = new int[N][M];
            visited = new boolean[N][M];

            // 배추 기록
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                graph[n][m] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        // 배추가 있는 곳이고 방문하지 않은 곳이면, 해당 위치를 기준으로 BFS를 하여 방문처리를 한다.
                        bfs(i, j);
                        count++;  // 지렁이 한 마리로 커버 가능한 연결된 배추들을 하나로 카운트
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    static void bfs(int x, int y) {
        queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;  // 방문 처리

        while (!queue.isEmpty()) {
            int [] current = queue.poll();  // 배추의 좌표
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                // nextX와 nextY는 graph 범위 내에 있어야 하고,
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    // 방문하지 않은 지점이어야 하며, 배추가 있는 곳일 때
                    if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true; // 방문 처리
                        queue.add(new int[]{nextX, nextY});  // 큐에 해당 좌표(배추의 위치)를 추가
                    }
                }
            }
        }
    }
}