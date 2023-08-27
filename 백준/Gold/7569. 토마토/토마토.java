import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] map;  // 게임판
    static boolean[][][] visited;  // 방문처리
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int days = 0;  // 일수
    static int yet = 0;  // 익지 않은 토마토의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        visited = new boolean[h][n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    map[i][j][k] = tomato;
                    if (tomato == 1) {  // 토마토가 있는 부분(1)은 큐에 추가하고 
                        queue.add(new int[] {j, k, i, 0});
                        visited[i][j][k] = true;  // 익은 토마토는 다시 방문할 필요가 없으니 true로 방문 처리
                    } else if (tomato == 0) {
                        yet++;  // 익지 않은 토마토(0)의 경우, yet을 증가
                    }
                }
            }
        }
        if (yet == 0) {  // 모든 토마토가 다 익은 경우
            System.out.println(0);
            return;
        }
        bfs(visited, queue);
        if (yet != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(days);
    }

    private static void bfs(boolean[][][] visited, Queue<int[]> queue) {
        int nextX, nextY, nextZ;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 6; i++) {
                nextX = pos[0] + dx[i];
                nextY = pos[1] + dy[i];
                nextZ = pos[2] + dz[i];

                if (nextX < 0 || nextX > n-1 || nextY < 0 || nextY > m-1 || nextZ < 0 || nextZ > h-1 ||
                map[nextZ][nextX][nextY] != 0 || visited[nextZ][nextX][nextY]) {
                    continue;   // 무시
                }

                map[nextZ][nextX][nextY] = 1;
                visited[nextZ][nextX][nextY] = true;
                yet--;
                days = Math.max(days, pos[3] + 1);
                queue.add(new int[] {nextX, nextY, nextZ, pos[3] + 1});
            }
        }
    }
}