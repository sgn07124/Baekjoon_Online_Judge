import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        area = new ArrayList<>();

        int pictureCnt = picCnt();
        int maxPicArea = area.isEmpty() ? 0 : Collections.max(area);  // 그림이 아예 없는 경우 Collections.max()를 사용하면 NoSuchElementException가 발생하므로, 빈 경우 0을 저장하도록 처리해야 함.
        bw.write(pictureCnt + "\n" + maxPicArea);
        bw.flush();
        bw.close();
    }

    private static int picCnt() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;  // 방문 처리
        int cnt = 1;  // 시작 위치의 그림 첫부분부터 카운트

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >=0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {  // 다음 위치가 범위 내에 있고, 방문하지 않은 곳이면서, 1인곳
                    visited[nx][ny] = true;  // 방문 처리
                    queue.add(new int[] {nx, ny});  // 다음 좌표 추가
                    cnt++;
                }
            }
        }
        area.add(cnt);
    }
}
