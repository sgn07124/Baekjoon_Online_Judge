import java.util.Scanner;

public class Main {
    public static int[][] branch;
    public static boolean[] visit;
    public static int V;  // 컴퓨터 수
    public static int E;  // edge
    public static int start;  // 시작 정점
    public static int cnt = 0;

    public static int dfs(int start) {
        visit[start] = true;
        for (int i = 1; i <= V; i++) {
            if (branch[start][i] == 1 && visit[i] == false) {
                cnt++;
                dfs(i);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        start = 1;
        branch = new int[101][101];  // 컴퓨터 수 최대 100대
        visit = new boolean[101];

        /* 인접 행렬 생성 */
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            branch[a][b] = branch[b][a] = 1;  // 무방향 그래프
        }
        System.out.println(dfs(1));
    }

}