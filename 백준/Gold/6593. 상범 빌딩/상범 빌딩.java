import java.io.*;
import java.util.*;

public class Main {
    static int l, r, c;
    static char [][][] building;
    static int [][][] dist;
    static Queue<int[]> queue = new LinkedList<>();
    static int [] dx = {0, 0, 0, 0, 1, -1};
    static int [] dy = {0, 0, 1, -1, 0, 0};
    static int [] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int start_x = 0, start_y = 0, start_z = 0;
            int end_x = 0, end_y = 0, end_z = 0;

            l = Integer.parseInt(st.nextToken());  // 층 수
            r = Integer.parseInt(st.nextToken());  // 행
            c = Integer.parseInt(st.nextToken());  // 열

            if (l == 0 && r == 0 & c == 0) break;

            building = new char[l][r][c];
            dist = new int[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        if (line.charAt(k) == 'S') {  // S: 시작 지점
                            start_z = i;
                            start_x = j;
                            start_y = k;
                        } else if (line.charAt(k) == 'E') {  // E: 출구
                            end_z = i;
                            end_x = j;
                            end_y = k;
                        } else {
                            building[i][j][k] = line.charAt(k);
                        }
                    }
                }
                br.readLine();
            }
            bfs(start_x, start_y, start_z);

            int answer = dist[end_z][end_x][end_y];

            if (answer == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }
    }

    static void bfs(int start_x, int start_y, int start_z) {
        queue.offer(new int[] {start_z, start_x, start_y});  // 층, 행, 열

        while (!queue.isEmpty()) {
            int [] temp = queue.poll();
            int z = temp[0];  // 층
            int x = temp[1];  // 행
            int y = temp[2];  // 열

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue;
                if (building[nz][nx][ny] == '#' || dist[nz][nx][ny] != 0) continue;
                queue.offer(new int[] {nz, nx, ny});
                dist[nz][nx][ny] = dist[z][x][y] + 1;
            }
        }
    }
}