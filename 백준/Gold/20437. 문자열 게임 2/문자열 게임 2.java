import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }

            int [] alpha = new int[26];
            for (int i = 0; i < W.length(); i++) {
                alpha[W.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 0; i < W.length(); i++) {
                if (alpha[W.charAt(i) - 'a'] < K) continue;

                int count = 1;
                for (int j = i + 1; j < W.length(); j++) {
                    if (W.charAt(i) == W.charAt(j)) count++;
                    if (count == K) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) sb.append("-1\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}