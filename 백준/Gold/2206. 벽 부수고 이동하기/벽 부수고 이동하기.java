import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int [][] map;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Queue<int []> queue = new LinkedList<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 출발지와 목적지가 같은 경우, 종료
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = line.charAt(j) - '0';
                if (num == 1) map[i][j] = num;
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        // 방문을 체크하는 3차원 배열
        // [0, n, m]: 벽 안 부수고 지나가는 방문 노드 경로
        // [1, n, m]: 벽 부수고 지나가는 방문 노드 경로
        int [][][] check = new int[2][n][m];

        queue.offer(new int[] {0, 0, 0});
        check[0][0][0] = 1;

        while (true) {
            int [] node = queue.poll();

            if (node == null) return -1;

            for (int i = 0; i < 4; i++) {
                int nx = node[1] + dx[i];
                int ny = node[2] + dy[i];

                // 범위 밖인 경우 pass
                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;

                // 지금 좌표가 벽이 아닌 경우
                if (node[0] == 0) {
                    // 다음 좌표가 벽이 아닌 경우
                    if (map[nx][ny] == 0 && check[0][nx][ny] == 0) {
                        queue.offer(new int[] {0, nx, ny});
                        check[0][nx][ny] = check[0][node[1]][node[2]] + 1;
                    }
                    // 다음 좌표가 벽인 경우
                    else if (map[nx][ny] == 1 && check[0][nx][ny] == 0) {
                        // 다음 좌표가 이전에 방문한 적이 있다면
                        if (check[1][nx][ny] == 0) {
                            queue.offer(new int[] {1, nx, ny});
                            check[1][nx][ny] = check[0][node[1]][node[2]] + 1;
                        }
                    }
                } else {
                    // 지금 좌표가 벽이고, 다음 좌표가 벽이 아닌 경우
                    if (map[nx][ny] == 0) {
                        if (check[1][nx][ny] == 0) {
                            queue.offer(new int[] {1, nx, ny});
                            check[1][nx][ny] = check[1][node[1]][node[2]] + 1;
                        }
                    }
                }
                if (nx == n - 1 && ny == m - 1) {
                    return Math.max(check[0][nx][ny], check[1][nx][ny]);
                }
            }
        }
    }
}