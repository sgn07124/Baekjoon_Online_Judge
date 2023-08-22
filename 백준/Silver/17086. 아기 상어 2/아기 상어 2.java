import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r;  // row
    int c;  // col
    int dis;  // distance

    public Node (int r, int c, int dis) {
        this.r = r;
        this.c = c;
        this.dis = dis;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // row
        int M = Integer.parseInt(st.nextToken());  // col

        boolean [][] map = new boolean[N][M];  // 아기 상어가 있는지 빈칸인지 저장할 배열. default = false
        int [][] dis_shark = new int[N][M];  // 가장 가까운 아기 상어와의 거리를 저장할 배열

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());  // 한 줄씩 입력을 받는데
            for (int j=0; j<M; j++) {  // 입력 받은 행의 각 열을 탐색하면서
                if (st.nextToken().equals("1"))  // 아기 상어가 있을 경우(1이 있는 경우)
                    map[i][j] = true;  // map의 아기 상어의 위치에 true를 저장
                else
                    dis_shark[i][j] = 1000;  // 빈칸인 경우
            }
        }
        //System.out.println(Arrays.deepToString(map));
        //System.out.println(Arrays.deepToString(dis_shark));
        LinkedList<Node> Queue;
        Node temp;
        boolean [][] visited;

        int [] dx = {0, 1, -1};
        int [] dy = {0, 1, -1};
        int r, c;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j])
                    continue;  // 상어가 있는 칸인 경우 continue
                visited = new boolean[N][M];  // 방문 배열 생성, default = false
                Queue = new LinkedList<Node>();  // 큐 생성
                Queue.addLast(new Node(i, j, 0));  // 현재 있는 곳에 대한 노드를 큐에 넣는다
                while (!Queue.isEmpty()) {
                    temp = Queue.removeFirst();  // 제일 앞 노드 꺼내기

                    // 모든 방향 탐색
                    for (int k=0; k<3; k++) {
                        for (int h=0; h<3; h++) {
                            if (k==0 && h==0) continue;  // 위아래 0칸 이동 == 현재 있는 칸이므로 continue
                            // 현재 위치에서 이동한 방향의 좌표를 r,c에 저장
                            r = temp.r + dx[k];
                            c = temp.c + dy[h];

                            if (r<0 || c<0 || r>=N || c>=M) continue;  // 범위를 넘어가는 경우
                            if (visited[r][c]) continue;  // 이미 방문한 칸일 경우
                            if (map[r][c]) {  // 아기 상어가 있는 칸인 경우
                                dis_shark[i][j] = temp.dis + 1;
                                break;
                            }
                            Queue.addLast(new Node(r, c, temp.dis+1));  // Queue에 해당 좌표의 거리를 저장
                            visited[r][c] = true;  // 방문 처리
                        }
                        if (dis_shark[i][j] < 1000) break;  // 0인 곳 == 아기 상어가 있는 곳
                    }
                    if (dis_shark[i][j] < 1000) break;
                }
            }
        }
        // 가장 큰 안전 거리
        int max = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                max = (dis_shark[i][j] > max) ? dis_shark[i][j] : max;
            }
        }
        System.out.println(max);
    }
}