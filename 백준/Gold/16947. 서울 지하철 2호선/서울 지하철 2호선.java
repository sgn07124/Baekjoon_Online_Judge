import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean [] isCycle;
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static int [] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        isCycle = new boolean[N + 1];  // 해당 정점의 순환 여부
        graph = new ArrayList[N + 1];
        distance = new int[N + 1];  // 순환선으로 부터 거리

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[v].add(e);
            graph[e].add(v);
        }

        for (int i = 1; i <= N; i++) {
            if (cycle_dfs(i, i, i)) break;  // dfs로 사이클을 찾는다.
        }

        for (int i = 1; i <= N; i++) {
            if (!isCycle[i]) distance[i] = distance_bfs(i);  // 사이클이 아닌 정점의 경우, 해당 정점으로 부터 사이클까지의 거리를 저장
        }

        for (int i = 1; i <= N; i++) sb.append(distance[i]).append(" ");
        System.out.println(sb);
    }

    private static boolean cycle_dfs(int start, int prev, int now) {
        isCycle[now] = true;  // 현재 노드를 사이클에 포함
        for (int next : graph[now]) {
            // 현재 노드와 인접한 노드(graph[now]) 탐색
            if (!isCycle[next]) {
                // 인접 노드가 현재 사이클에 포함되지 않는 노드라면?
                if (cycle_dfs(start, now, next)) {
                    return true;
                }
            } else if (prev != next && next == start) return true;  // 이전 노드가 다음 노드가 되는 무한 반복을 방지. next == start : cycle
        }
        isCycle[now] = false;  // 현재 노드는 사이클이 아니므로 false 처리
        return false;
    }

    private static int distance_bfs(int start) {
        visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (isCycle[now.num])  return now.distance;  // 해당 정점이 사이클이면, 거리 반환
            for (int next : graph[now.num]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, now.distance + 1));
                }
            }
        }
        return 0;
    }

    private static class Node {
        int num, distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}