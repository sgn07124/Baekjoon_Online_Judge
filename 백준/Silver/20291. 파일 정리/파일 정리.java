import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String [] str = br.readLine().split("\\.");  // regex 패턴 주의!!!
            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < map.size(); i++) {
            sb.append(list.get(i)).append(' ').append(map.get(list.get(i))).append('\n');
        }
        System.out.println(sb);
    }
}