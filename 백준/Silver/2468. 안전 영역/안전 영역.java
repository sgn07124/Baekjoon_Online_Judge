import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int [][] map;  // 지도
    static int [] dx = {-1, 1, 0, 0};  // 동서남북
    static int [] dy = {0, 0, -1, 1};
    static int n, count;
    static boolean [][] visited;  // 방문 지점 기록
    static ArrayList<Integer> list;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[100][100];
        visited = new boolean[100][100];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);  // 각 높이를 입력 받아 가장 높은 지역의 값을 저장
            }
        }
        list = new ArrayList<>();
        list.add(1);
        for (int h = 1; h < max; h++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k] == false && map[j][k] > h) {  // 잠기지 않은 안전 영역의 dfs 시작점
                        dfs(j, k, h);
                        count++;
                    }
                }
            }
            list.add(count);
            visited = new boolean[n][n];
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    static void dfs(int a, int b, int x) {
        visited[a][b] = true;  // 시작 지점을 방문 처리
        int nextX, nextY;
        for (int i = 0; i < 4; i++) {  // bfs 동서남북
            nextX = a + dx[i];
            nextY = b + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && map[nextX][nextY] > x && visited[nextX][nextY] == false) {
                dfs(nextX, nextY, x);
            }
        }
    }
}