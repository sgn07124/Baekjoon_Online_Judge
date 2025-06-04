import java.util.*;
import java.io.*;

public class Main {
    static int m, n, h;
    static int days = 0, yet = 0;
    static int [][][] storage;
    static boolean [][][] visited;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int [] dx = {-1, 1, 0, 0, 0, 0};
    static int [] dy = {0, 0, 1, -1, 0, 0};
    static int [] dh = {0, 0, 0, 0, 1, -1};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        storage = new int[h][n][m];
        visited = new boolean[h][n][m];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < m; l++) {
                    storage[i][j][l] = Integer.parseInt(st.nextToken());
                    // 익은 토마토의 경우
                    if (storage[i][j][l] == 1) {
                        queue.add(new int[] {j, l, i, 0});  // x, y, h, day
                        visited[i][j][l] = true;  // 익은 토마토는 방문할 필요가 없음
                    } else if (storage[i][j][l] == 0) {
                        // 익지 않은 토마토의 경우
                        yet++; 
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
            int [] current = queue.poll();
            
            for (int i = 0; i < 6; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int nh = current[2] + dh[i];
                
                // 다음 값들이 범위 내에 있고, 방문하지 않았으며, 익지 않은 토마토가 있다면
                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < n && ny < m && nh < h && !visited[nh][nx][ny] && storage[nh][nx][ny] == 0) {
                    storage[nh][nx][ny] = 1;  // 익은 토마토로 바꾸고,
                    visited[nh][nx][ny] = true; // 방문 처리
                    yet--;  // 익지 않은 토마토의 개수 감소
                    days = Math.max(days, current[3] + 1);
                    queue.add(new int[] {nx, ny, nh, current[3] + 1});
                }
            }
        }
    }   
}