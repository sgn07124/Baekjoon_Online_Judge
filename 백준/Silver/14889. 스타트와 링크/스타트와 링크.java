import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] map;
    static boolean [] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(min);
    }

    private static void combi(int idx, int count) {
        // 방문한 팀과 방문하지 않은 팀을 각각 나누어 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i 번째 사람과 j 번째 사람이 모두 true라면 스타팀 점수 증가
                if (visit[i] && visit[j]) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (!visit[i] && !visit[j]){
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(val, min);
    }
}