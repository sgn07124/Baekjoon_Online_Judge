import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static char [][] graph;
    static boolean [][] visited;
    static Queue<int[]> queue;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 적록색약인 사람: R-G를 하나로 카운트.
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        int regions = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    regions++;
                }
            }
        }
        sb.append(regions).append(" ");
        regions = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    regions++;
                }
            }
        }
        sb.append(regions);
        System.out.println(sb);
    }

    static void bfs(int x, int y, boolean isBlind) {
        queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        char startColor = graph[x][y];

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (isBlind) {
                        if ((startColor == 'R' || startColor == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                            // 현재 색상이 R 또는 G이고, 다음 색상도 R 또는 G인 경우
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        } else if (startColor == graph[nx][ny]) {  // 다음 색상도 startColor와 같다면?
                            // 현재 색상이 B인 경우, B만 탐색
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    } else {
                        if (graph[nx][ny] == startColor) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
}