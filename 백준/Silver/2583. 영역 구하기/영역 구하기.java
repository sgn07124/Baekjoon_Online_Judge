import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int [][] map;
    static boolean [][] visited;
    static int count = 0;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0 , -1, 1};
    static List<Integer> list = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();
    static Queue<int []> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 행
        M = Integer.parseInt(st.nextToken());  // 열
        K = Integer.parseInt(st.nextToken());  // 사각형 개수
        map = new int[M][N];
        visited = new boolean[M][N];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());
            for (int i = firstX; i < secondX; i++) {
                for (int j = firstY; j < secondY; j++) {
                    visited[i][j] = true;  // 사각형이 만들어지는 곳을 방문 처리
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        Collections.sort(list);
        sb.append(count).append('\n');
        for (int cnt : list) {
            sb.append(cnt).append(' ');
        }
        System.out.println(sb);
    }
    static void bfs(int x, int y) {
        int cnt = 1;  // 분리된 영역의 칸 수
        visited[x][y] = true;
        queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int [] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                    cnt++;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        list.add(cnt);
    }
}