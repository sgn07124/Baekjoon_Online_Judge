import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static boolean [] visit;
    static int [] S;
    static int [] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            S = new int[k];
            visit = new boolean[k];
            result = new int[6];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void lotto(int start, int depth) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = S[i];
                lotto(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}