import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [][] map;
    static Queue<int[]> person;
    static Queue<int[]> fire;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            person = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        person.add(new int[] {j, i, 0});
                    } else if (map[i][j] == '*') {
                        fire.add(new int[] {j, i});
                    }
                }
            }
            int res = -1;
            out : while (true) {
                // 불 번짐
                int fSize = fire.size();
                for (int i = 0; i < fSize; i++) {
                    int [] pos = fire.poll();
                    int px = pos[0];
                    int py = pos[1];
                    fireMarking(px, py);
                }

                // 상근 이동
                int pSize = person.size();
                for (int i = 0; i < pSize; i++) {
                    int [] pos = person.poll();
                    int px = pos[0];
                    int py = pos[1];
                    int time = pos[2];
                    res = escape(px, py, time);
                    if (res != -1) break out;
                }
                if (person.isEmpty()) break;  // 상근이가 탈출한 경우
            }
            if (res != -1) sb.append(res).append('\n');
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }

    static void fireMarking(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                if (map[ny][nx] == '.' || map[ny][nx] == '@') {
                    map[ny][nx] = '*';
                    fire.add(new int[] {nx, ny});
                }
            }
        }
    }

    static int escape(int x, int y, int time) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > w - 1 || ny < 0 || ny > h - 1) {
                return time + 1;
            }
            if (map[ny][nx] == '.') {
                map[ny][nx] = '@';
                person.add(new int[] {nx, ny, time + 1});
            }
        }
        return -1;
    }
}