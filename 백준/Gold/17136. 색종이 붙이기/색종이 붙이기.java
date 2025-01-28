import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] map;
    static int [] paper = {0, 5, 5, 5, 5, 5};  // 색종이는 각 5장씩 있다.
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt) {
        // 맨 끝점에 도달 시, ans와 cnt를 비교하고 종료
        if (x >= 9 && y > 9) {
            ans = Math.min(ans, cnt);
            return;
        }

        // 최솟값을 구해야 하므로 ans <= cnt가 되는 순간 리턴
        if (ans <= cnt) return;

        if (y > 9) {
            dfs(x + 1, 0, cnt);  // 아래줄로 이동
            return;
        }

        // map의 1의 칸에 도착하면 가장 큰 색종이부터 비교
        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                // 특정 크기의 색종이 개수가 남아있고, 색종이를 붙일 수 있다면?
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    attach(x, y, i, 0);  // 색종이를 붙임
                    paper[i]--; // 사용한 색종이 장수를 줄이고
                    dfs(x, y + 1, cnt + 1);
                    attach(x, y, i, 1);  // 색종이를 다시 떼고
                    paper[i]++;  // 다시 장수를 늘리고
                }
            }
        } else {
            dfs(x, y + 1, cnt);  // 오른쪽으로 이동
        }
    }

    // 색종이를 붙일 수 있는지 확인
    private static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }

    // 색종이를 붙이는 함수
    private static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }
}