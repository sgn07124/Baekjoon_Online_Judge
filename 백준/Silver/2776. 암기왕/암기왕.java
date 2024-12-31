import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Set<Integer> set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}