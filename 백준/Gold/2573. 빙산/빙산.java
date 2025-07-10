import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [][] map;
    static Queue<int []> queue;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  // 행
        m = Integer.parseInt(st.nextToken());  // 열

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        // 빙하가 2개 이상 분리될 경우
        while ((cnt = SeparateNum()) < 2) {

            if (cnt == 0) {
                ans = 0;
                break;
            }
            Melt();
            ans++;
        }

        System.out.println(ans);
    }

    private static void Melt() {
        queue = new LinkedList<>();

        boolean [][] visited = new boolean[n][m];  // visited 배열이 없으면, 1 2가 있을 때 1이 녹으면 바다가 되면서 2에 영향을 줌
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {  // 빙하인 곳을 큐에 추가
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int seaNum = 0;  // 빙하 상하좌우에 존재하는 바다 영역의 수
            int [] iceberg = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = iceberg[0] + dx[i];
                int ny = iceberg[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && map[nx][ny] == 0) seaNum++;
            }
            if (map[iceberg[0]][iceberg[1]] - seaNum < 0) {  // 1년 지난 후에 빙하가 0 아래(minus)이면 0을 저장
                map[iceberg[0]][iceberg[1]] = 0;
            } else {
                map[iceberg[0]][iceberg[1]] -= seaNum;
            }
        }
    }

    private static int SeparateNum() {
        boolean [][] visited = new boolean[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {  // 바다가 아니고, 방문하지 않은 경우
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, boolean [][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[nx][ny] != 0 && !visited[nx][ny]) dfs(nx, ny, visited);  // 다음 값이 바다가 아니고, 방문하지 않은 경우, dfs() -> 연결된 섬인지
        }
    }
}