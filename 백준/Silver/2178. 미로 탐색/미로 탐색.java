import java.util.*;
import java.io.*;
import java.awt.Point;

class Main {
    static int [][] graph;
    static boolean [][] visited;
    static int n, m;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int [n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        
        visited = new boolean[n][m];
        bfs(0, 0);
        System.out.println(graph[n - 1][m - 1]);
    }
    
    private static void bfs(int x, int y) {
        Queue<Point> queue =  new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || graph[nx][ny] == 0 || visited[nx][ny]) continue;
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                graph[nx][ny] = graph[current.x][current.y] + 1;
            }
        }
    }
}