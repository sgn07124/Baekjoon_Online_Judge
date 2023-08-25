import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] map;  // 게임판
    static boolean[][] visited;  // 방문
    static int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int [] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int nowX, nowY;  // 현재 위치 칸
    static int desX, desY;  // 이동하려는 칸

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});  // 시작 지점을 큐에 추가

        while (!queue.isEmpty()) {
            int[] now = queue.poll();  // 빼고
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nexyY = nowY + dy[i];

                if (nextX < 0 || nextX >= n || nexyY < 0 || nexyY >= n || map[nextX][nexyY] != 0 || visited[nextX][nexyY]) {
                    continue;  // 벽이거나 방문한 지점이거나 게임판을 넘어간 경우 무시
                }

                visited[nextX][nexyY] = true;  // 방문 처리
                map[nextX][nexyY] = map[nowX][nowY] + 1;  // count 하면서 이동하므로 1를 더해줌
                queue.add(new int[] {nextX, nexyY});  // 이동한 지점의 좌표를 큐에 추가
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // test case

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();  // 게임판 한 변 칸 수
            map = new int[n][n];
            visited = new boolean[n][n];

            nowX = sc.nextInt();
            nowY = sc.nextInt();
            desX = sc.nextInt();
            desY = sc.nextInt();

            visited[nowX][nowY] = true;  // 시작 지점을 방문 처리
            bfs(nowX, nowY);
            System.out.println(map[desX][desY]);
        }
    }
}