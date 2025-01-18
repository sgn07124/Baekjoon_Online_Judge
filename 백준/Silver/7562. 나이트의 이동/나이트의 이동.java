import java.io.*;
import java.util.*;

public class Main {
    static int [][] map;
    static boolean [][] visited;
    static int count = 0;
    static int l, nowX, nowY, desX, desY;
    static Queue<int []> queue = new ArrayDeque<>();
    static int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int [] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());  // 체스판의 한 변의 길이
            map = new int[l][l];
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            // 나이트의 위치
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            // 나이트가 이동하려고 하는 칸
            desX = Integer.parseInt(st.nextToken());
            desY = Integer.parseInt(st.nextToken());
            bfs(nowX, nowY);
            sb.append(map[desX][desY]).append('\n');  // 해당 위치의 가중치가 이동 횟수
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int [] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[now[0]][now[1]] + 1;  // 이동 횟수를 1만큼 증가시켜 저장
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}