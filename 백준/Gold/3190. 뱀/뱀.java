import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int [][] arr;
    // 방향 순서가 시계 방향으로 움직여야 함.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());  // 보드의 크기
        K = Integer.parseInt(br.readLine());  // 사과의 개수

        arr = new int[N][N];

        // 사과의 위치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());  // 행
            int col = Integer.parseInt(st.nextToken());  // 열
            arr[row - 1][col - 1] = 1;  // 사과의 좌표에 1을 표시
        }

        L = Integer.parseInt(br.readLine());  // 뱀의 방향 변환 횟수

        Queue<Move> moves = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            moves.add(new Move(X, C));
        }

        int nowSec = 0;
        int x = 0;
        int y = 0;
        int dirIdx = 0;
        char dir;

        // 다음 사과의 위치
        Move poll = moves.poll();
        int nextSec = poll.x;
        char nextDir = poll.c;

        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[] {0, 0});

        while (true) {
            nowSec++;

            x += dx[dirIdx];
            y += dy[dirIdx];

            if (x >= 0 && x < N && y >= 0 && y < N && !contains(snake, x, y)) {
                snake.add(new int[] {x, y});  // 뱀 머리 이동
                if (arr[y][x] == 1) arr[y][x] = 0;  // 사과가 있는 경우
                else snake.poll();

                // 명령 실행 시간이라면? 방향 변환
                if (nowSec == nextSec) {
                    dir = nextDir;
                    if (dir == 'D') {
                        dirIdx = (dirIdx + 1) % 4;
                    } else if (dir == 'L') {
                        dirIdx = (dirIdx + 3) % 4;
                    }
                    if (!moves.isEmpty()) {
                        poll = moves.poll();
                        nextSec = poll.x;
                        nextDir = poll.c;
                    }
                }
            } else break;
        }
        System.out.println(nowSec);
    }

    private static boolean contains(Queue<int []> snake, int x, int y) {
        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) {
                return true;
            }
        }
        return false;
    }

    private static class Move {
        int x;
        char c;

        public Move(int sec, char dir) {
            this.x = sec;
            this.c = dir;
        }
    }
}