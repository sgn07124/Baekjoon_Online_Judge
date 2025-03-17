
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 싸이클 확인 방법 (BFS)
 * 1) 첫 번째로 선택한 점과 마지막에 선택한 점이 같아야 한다.
 * 2) 선택된 점들의 개수가 4개 이상이어야 한다.
 *
 * 싸이클이 1개라도 존재하면 Yes, 존재하지 않으면 NO
 */

public class Main {
    static char [][] map;
    static boolean [][] visit;
    static int N, M, firstX, firstY;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean isCycle = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit = new boolean[N][M];
                firstX = i;
                firstY = j;
                if (dfs(firstX, firstY, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(int x, int y, int count) {
        visit[x][y] = true;  // 첫 지점 방문 처리
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && map[nextX][nextY] == map[x][y]) {
                // 다음 탐색 지점이 방문하지 않은 점인 경우
                if (!visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    if (dfs(nextX, nextY, count + 1)) return true;
                } else {
                    if (count >= 4 && firstX == nextX && firstY == nextY) return true;
                }
            }
        }
        return false;
    }
}
