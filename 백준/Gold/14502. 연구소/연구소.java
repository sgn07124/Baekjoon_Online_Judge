
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
조건) 벽의 개수는 3개이고, 3개를 모두 사용해야 한다.

1. 연구소의 모든 칸에 벽을 세우려면 빈칸 유무를 확인해야 함 --> dfs
2. 바이러스는 상하좌우 인접한 방향으로 전이 --> bfs
3. 바이러스를 퍼트려 얻을 수 있는 안전 영역의 최댓값을 계속 구한다.
 */

public class Main {
    static int N, M;
    static int [][] originalMap;  // 원본 배열을 수정하면 안됨 (벽 3개를 추가하기 전)
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static int maxSafeZone = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originalMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        wall_dfs(0);
        System.out.println(maxSafeZone);
    }

    private static void wall_dfs(int wallCnt) {
        // 벽이 3개가 설치된 경우, bfs를 시작하여 바이러스 전이
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 해당 칸이 빈칸이면?
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;  // 벽을 세우고
                    wall_dfs(wallCnt + 1);  // 다음으로 벽을 세울 곳을 찾아 ㄱㄱ
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originalMap[i][j] == 2) queue.offer(new Node(i, j));  // 바이러스 queue에 추가
            }
        }

        // 원본 연구소를 바꾸지 않기 위해 originalMap 복제
        int [][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copyMap[nx][ny] == 0) {
                    queue.offer(new Node(nx, ny));  // 바이러스 전이
                    copyMap[nx][ny] = 2;
                }
            }
        }
        isSafeZone(copyMap);
    }

    private static void isSafeZone(int [][] copyMap) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) safeZone++;
            }
        }
        if (maxSafeZone < safeZone) maxSafeZone = safeZone;
    }
    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}