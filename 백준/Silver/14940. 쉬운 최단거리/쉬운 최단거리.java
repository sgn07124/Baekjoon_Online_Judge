
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, -1, 0, 1};
    static int [][] map;
    static int [][] distance;
    static boolean [][] visited;
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startX = -1, startY = -1;

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            if (!start) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2) {
                        start = true;
                        startX = i;
                        startY = j;
                        break;
                    }
                }
            }
        }
        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (map[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;

                queue.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[current.x][current.y] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
