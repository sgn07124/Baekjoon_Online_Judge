import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] board;
    static int [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 사다리의 수
        int m = Integer.parseInt(st.nextToken());  // 뱀의 수

        board = new int[101];
        visited = new int[101];

        for (int i = 1; i < board.length; i++) board[i] = i;  // 인덱스 번호 == 자리 번호

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;  // 사다리 -> 사다리의 시작 지점(x)의 위치에 도착 지점(y) 인덱스를 저장
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;  // 뱀 인덱스 저장
        }

        int result = bfs(1);
        System.out.println(result);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 0;  //

        while (true) {
            int node = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int newNode = node + i;

                if (newNode > 100) continue;  // board의 범위를 넘어가면 무시

                // 방문한 기록이 없는 경우
                if (visited[board[newNode]] == 0) {
                    queue.offer(board[newNode]);
                    visited[board[newNode]] = visited[node] + 1;
                }

                if (board[newNode] == 100) return visited[100];
            }
        }
    }
}