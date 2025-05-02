import java.util.*;

class Solution {
    int [] dx = {-1, 1, 0, 0};
    int [] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean [][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int [] {0, 0, 1});  // 시작 좌표(0, 0), 걸어온 거리
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];
            
            if (x == n - 1 && y == m - 1) return cnt;  // 상대 진영 도착 시, 걸어온 거리 return
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 이동한 칸이 범위 내에 있고, 벽이 아니고, 방문하지 않았다면?
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;  // 방문 처리
                    queue.add(new int[] {nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}