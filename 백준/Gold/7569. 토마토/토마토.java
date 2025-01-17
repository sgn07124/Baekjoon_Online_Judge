import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int yet = 0, days = 0;
    static int [][][] storage;
    static boolean [][][] visited;
    static int [] dx = {1, -1, 0, 0, 0, 0};
    static int [] dy = {0, 0, -1, 1, 0, 0};
    static int [] dz = {0, 0, 0, 0, 1, -1};
    // 전체적으로 일수를 계산하는 것이므로 Queue에 토마토를 입력받으면서 넣야야 한다!!
    static Queue<int []> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());  // 가로
        N = Integer.parseInt(st.nextToken());  // 세로
        H = Integer.parseInt(st.nextToken());  // 높이

        storage = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < M; l++) {
                    storage[i][j][l] = Integer.parseInt(st.nextToken());
                    if (storage[i][j][l] == 1){
                        queue.add(new int[] {j, l, i, 0});  // x, y, h, day
                        visited[i][j][l] = true;  // 익은 토마토는 방문할 필요가 없으므로 방문 처리
                    } else if (storage[i][j][l] == 0) {
                        yet++;  // 익지 않은 토마토의 개수
                    }
                }
            }
        }

        if (yet == 0) {
            System.out.println(days);
            return;
        }
        bfs();
        if (yet != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(days);
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int [] pos = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                int nz = pos[2] + dz[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (!visited[nz][nx][ny] && storage[nz][nx][ny] == 0) {
                        storage[nz][nx][ny] = 1;  // 익은 토마토 처리
                        visited[nz][nx][ny] = true;  // 방문 처리
                        yet--;
                        days = Math.max(days, pos[3] + 1);
                        queue.add(new int[] {nx, ny, nz, pos[3] + 1});
                    }
                }
            }
        }
    }
}