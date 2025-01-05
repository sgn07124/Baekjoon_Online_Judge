import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static char [] arr;
    public static boolean [] visit;
    public static char [] ans;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            arr = new char[s.length()];
            visit = new boolean[s.length()];
            ans = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                arr[j] = s.charAt(j);
            }
            Arrays.sort(arr);
            dfs(0);
        }

        System.out.println(sb);
    }
    public static void dfs(int depth) {
        if (depth == arr.length) {
            for (char an : ans) {
                sb.append(an);
            }
            sb.append('\n');
            return;
        }
        char before = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) continue;

            if (arr[i] != before) {
                visit[i] = true;
                before = arr[i];
                ans[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}