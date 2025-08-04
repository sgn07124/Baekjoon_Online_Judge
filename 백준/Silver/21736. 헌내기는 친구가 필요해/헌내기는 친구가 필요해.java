import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static char [][] map;
    static boolean [][] visited;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Deque<int[]> queue = new ArrayDeque<>();
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char [n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    queue.addLast(new int [] {i, j});
                }
            }
        }
        
        bfs();
        
        System.out.println(ans > 0 ? ans : "TT");
    }
    
    static void bfs() {
        while (!queue.isEmpty()) {
            int [] tmp = queue.removeFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] != 'X' && !visited[nx][ny]) {
                    // 벽이 아니고 방문하지 않았다면?
                    if (map[nx][ny] == 'P') ans++; // 사람이 있으면?
                    visited[nx][ny] = true;
                    queue.addLast(new int[] {nx, ny});
                }
            }
        }
    }
}