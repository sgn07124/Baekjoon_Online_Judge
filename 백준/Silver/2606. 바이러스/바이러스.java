import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int [][] graph;
    static boolean [] visited;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         N = Integer.parseInt(br.readLine());  // vertex
         M = Integer.parseInt(br.readLine());  // edge
         
         graph = new int [N + 1][N + 1];
         visited = new boolean[N + 1];
         
         for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             graph[a][b] = graph[b][a] = 1;
         }
         
         bfs(1);
    }
    
    static void bfs(int node) {
        int count = 0;
        queue.offer(node);
        visited[node] = true;
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            
            for (int next = 1; next <= N; next++) {
                if (graph[tmp][next] == 1 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}