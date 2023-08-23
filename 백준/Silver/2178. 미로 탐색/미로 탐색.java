import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
        큐로 진행하면서 이동 가능한 방향의 좌표를 Queue에 넣고 poll값으로 탐색을 진행한다(bfs)
        dfs로 진행하면 스택이므로 한 방향에서 도달이 끝나면 그게 최적인 경우가 아닌 경우가 발생할 수 있으므로 부적합할 듯..?

     */
    static int N;
    static int M;
    static int[][] map;  // 게임 판
    static boolean[][] visited;  // 방문 여부

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();  // queue에 {x,y}의 좌표 형식으로 저장됨
        queue.add(new int[] {x , y});  // 시작 좌표가 들어감

        int [][] pos = {{1,0}, {-1,0}, {0,-1}, {0, 1}};  // 동서남북

        while(!queue.isEmpty()) {  // queue가 비어있지 않으면
            int[] xy = queue.poll();  // queue의 마지막에 들어온 값을 poll

            for (int i = 0; i < 4; i++) {  // 동, 서, 남, 북 탐색.   xy(poll한 값)를 기준으로 인접하여 탐색 가능한 좌표를 nextX와 nextY에 저장
                int nextX = xy[0] + pos[i][0];  // 이동한 위치의 x좌표
                int nextY = xy[1] + pos[i][1];  // 이동한 위치의 y좌표

                // 다음 지점이 미로를 벗어나거나, 방문한 좌표(visited==true)이거나, 벽(map==0)이면 무시
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;  // 아래 조건 무시하고 다음 좌표로 이동
                }
                queue.add(new int[] {nextX, nextY});  // 다음 탐색 지점을 큐에 추가

                visited[nextX][nextY] = true;  // 다음 탐색 지점 방문 처리
                map[nextX][nextY] = map[xy[0]][xy[1]] + 1;  // 이 부분 이해 안됨... +1을 왜 하는건지 모르겠음
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // row
        M = Integer.parseInt(st.nextToken());  // col

        map = new int[N][M];
        visited = new boolean[N][M];
        visited[0][0] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';  // str.charAt(j)에 입력되는 값이 1 또는 0의 문자가 입력되니 아스키코드로 1(49), 0(48)이므로 정수형 1 또는 0이 저장됨
            }
        }
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }
}