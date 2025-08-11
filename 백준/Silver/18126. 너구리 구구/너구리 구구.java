import java.util.*;
import java.io.*;

class Main {
    static int n, a, b, c;
    static ArrayList<Edge>[] edges;
    static boolean [] visited;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        edges = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
            
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            // 양방향 연결
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }
        
        visited[1] = true;
        dfs(1, 0);
        System.out.println(answer);
    }
    
    static void dfs(int now, long dist) {
        if (answer < dist)
            answer = dist;

        for (Edge next : edges[now]) {
            // 다음 노드를 방문한 경우는 통과
            if (visited[next.node]) continue;
            visited[next.node] = true;
            dfs(next.node, dist + next.dis);
        }
    }
    
    static class Edge {
        int node;
        long dis;
        public Edge(int node, long dis) {
            this.node = node;
            this.dis = dis;
        }
    }
}