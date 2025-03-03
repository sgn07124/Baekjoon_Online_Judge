import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int answer;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                // 의상 종류에 따라 map에 저장.
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            answer = 1;
            for (String key : map.keySet()) {
                answer *= map.get(key) + 1;
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}