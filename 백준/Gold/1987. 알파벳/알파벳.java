import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int [][] board;
    static boolean [] visited;
    static int answer = 0;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }

        visited[board[0][0]] = true;
        dfs( 0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        if (count == r * c) {
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue;

            if (visited[board[ny][nx]]) {
                answer = Math.max(answer, count);
                continue;
            }
            visited[board[ny][nx]] = true;
            dfs(nx, ny, count + 1);
            visited[board[ny][nx]] = false;
        }


    }
}
