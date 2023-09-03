import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] cnt = new int[26];

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            cnt[(int)input.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < cnt.length; i++) {
            sb.append(cnt[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}