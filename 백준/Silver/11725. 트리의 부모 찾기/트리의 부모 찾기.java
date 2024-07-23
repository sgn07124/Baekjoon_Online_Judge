import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<List<Integer>> adjList;  // 인접 리스트
    static boolean[] visited;
    static int[] parents;  // 부모

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();  // 인접 리스트 생성
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        dfs(1); // 루트 노드를 1로 설정하고 시작

        for (int i = 2; i <= N; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush(); bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;  // 현재 노드를 방문 처리

        // 인접 리스트 순회 
        for (int node : adjList.get(now)) {
            if (!visited[node]) {  // 방문하지 않은 노드라면?
                parents[node] = now;  // 인접 노드의 부모를 현재 노드로 설정하고
                dfs(node);// 인점 노드 방문
            }
        }
    }
}