import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char [][] students = new char[5][5];
    static boolean [][] visit = new boolean[5][5];
    static int [] dx = new int[] {-1, 1, 0, 0};
    static int [] dy = new int[] {0, 0, 1, -1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                students[i][j] = line.charAt(j);
            }
        }
        dfs(0, 0);
        System.out.println(count);

    }

    static void dfs(int start, int depth) {
        if (depth == 7) {
            if (checkLinked()) count++;
        } else {
            // 25개의 자리 중 7개를 선택
            for (int i = start; i < 25; i++) {
                visit[i / 5][i % 5] = true;
                dfs(i + 1, depth + 1);
                visit[i / 5][i % 5] = false;
            }
        }
    }

    private static boolean checkLinked() {
        //연속된 7자리에 대해서 copy
        boolean[][] cpyVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            cpyVisited[i] = visit[i].clone();
        }

        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cpyVisited[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }

        //연속된 7자리인지, 이다솜파 과반수 이상인지 확인
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        int cnt = 0;
        int s = 0;
        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++){
                int mvx = poll.x + dx[i];
                int mvy = poll.y + dy[i];

                if (0 > mvx || 5 <= mvx || 0 > mvy || 5 <= mvy) { //범위를 넘어감
                    continue;
                }

                if (cpyVisited[mvx][mvy]) {
                    if (students[mvx][mvy] == 'S') s++; //이다솜파
                    cnt++; //연결된 사람들 확인
                    q.add(new Point(mvx, mvy));
                    cpyVisited[mvx][mvy] = false;
                }
            }
        }
        if (cnt == 7 && 4 <= s) {
            return true;
        }
        return false;
    }
}