import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이 문제에서는 Arrays.sort(arr)를 했을 때, 단순히 num[i] == num[i-1]를 하면 안된다.
 * (한 번은 출력하고 그 다음부터 중복된 수열은 출력하면 안되기 때문)
 *
 * 그럼?
 * for문이 시작하기 전에 before 변수를 선언하고, for문이 돌 때 이전에 중복된 것이 있었는가를 확인한다.
 * bfs를 진행하면서 if(before != arr[i])를 만족하지 않는 부분은 중복된 값이므로 continue를 하며 진행한다.
 */

public class Main {

    static int[] arr;
    static int[] out;
    static boolean[] visited;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        out = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dfs(0);
    }

    static void dfs(int cnt){
        if(cnt == M){
            for(int i = 0; i<M; i++)
                System.out.print(out[i]+" ");
            System.out.println();
        }

        else{
            int before = 0;
            for(int i = 0; i<N; i++){
                if(visited[i])
                    continue;

                if(before != arr[i]){
                    visited[i] = true;
                    out[cnt] = arr[i];
                    before = arr[i];
                    dfs(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}