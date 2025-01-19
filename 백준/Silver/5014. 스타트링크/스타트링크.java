import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] floor;
    static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());  // 전체 층 개수
        S = Integer.parseInt(st.nextToken());  // 강호의 위치
        G = Integer.parseInt(st.nextToken());  // 사무실의 위치
        U = Integer.parseInt(st.nextToken());  // 위로 이동 칸수
        D = Integer.parseInt(st.nextToken());  // 아래로 이동 칸수

        floor = new int[F + 1];

        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        floor[S] = 1;  // 시작점 방문

        while (!queue.isEmpty()) {
            int now = queue.poll();  // 현재 위치

            if (now == G) {  // 현재 위치 == 사무실 위치
                System.out.println(floor[now] - 1);
            }

            if (now + U <= F && floor[now + U] == 0) {
                // 현재 위치 + UP <= 최고층 && 방문 X
                floor[now + U] = floor[now] + 1;
                queue.add(now + U);
            }

            if (now - D > 0 && floor[now - D] == 0) {
                // 현재 위치 - Down > 0 && 방문 X
                floor[now - D] = floor[now] + 1;
                queue.add(now - D);
            }
        }
        if (floor[G] == 0) {
            System.out.println("use the stairs");
        }
    }
}