import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사각형에 넴모가 있는 경우와 없는 경우를 dfs를 돌리면서 구해주면 되며, 넴모가 2x2 사각형을 이루면 없어지도록 처리하면 된다.
 */

public class Main {
    public static int N, M;
    public static boolean [][] visit;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 행
        M = Integer.parseInt(st.nextToken());  // 열

        visit = new boolean[N + 1][M + 1];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == N * M) {
            answer++;
            return;
        }

        // dfs를 돌면 오른쪽으로 한 칸 진행하고, 한 줄이 끝나면 다음 줄에서 다시 진행한다.
        int x = depth / M + 1;
        int y = depth % M + 1;

        // 사각형이 이루어지는 경우에는 해당 위치에 넴모를 배치하지 않고 탐색을 진행한다.
        if (visit[x - 1][y] && visit[x][y - 1] && visit[x - 1][y - 1]) {
            dfs(depth + 1);
        } else {
            dfs(depth + 1);
            visit[x][y] = true;
            dfs(depth + 1);
            visit[x][y] = false;
        }
    }
}