import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static char [][] map;
    static Queue<int []> q = new ArrayDeque<>();
     static boolean canGo = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char [] ch = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = ch[j];
                if (map[i][j] == 'W') q.add(new int[] {i, j});  // 늑대 위치 저장
            }
        }

        bfs();

        if (canGo) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int [] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (map[nx][ny] == '.') map[nx][ny] = 'D';
                    if (map[nx][ny] == 'S') {
                        canGo = true;
                        return;
                    }
                }
            }
        }
    }
}