import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char [][] graph;
    static boolean [][] visited;
    static Queue<int[]> queue;  // x, y로 기입
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        
        // 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        
        // 적록색약이 아닌 사람이 봤을 때의 구역의 수
        int region = 0;  // 구역 수
        visited = new boolean[n][n];  // 방문 여부
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은 지역 == 색이 바뀌는 구역의 첫 시작점
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    region++;
                }
            }
        }
        sb.append(region).append(" ");
        
        // 적록색약인 사람이 봤을 때의 구역의 수
        region = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    region++;
                }
            }
        }
        sb.append(region);
        System.out.println(sb);
    }
    
    static void bfs(int x, int y, boolean isBlind) {
        queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;  // 방문 처리
        char startColor = graph[x][y];  // 시작 색상
        
        while (!queue.isEmpty()) {
            // 현재 x, y 값
            int [] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 상하좌우로 다음 값을 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 다음 좌표가 범위 내에 있고, 방문하지 않은 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    // 적록색약인 경우
                    if (isBlind) {
                        if ((startColor == 'R' || startColor == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                            queue.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        } else if (startColor == 'B' && graph[nx][ny] == 'B') {
                            queue.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    } else {  // 적록색약이 아닌 경우
                        if (startColor == graph[nx][ny]) {
                            queue.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
}