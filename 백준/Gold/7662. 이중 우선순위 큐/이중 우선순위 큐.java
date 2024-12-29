import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());  // 테스트 데이터
        
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());  // Q에 적용할 연산의 개수
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String c = st.nextToken();  // 'D' or 'I'

                if (c.equals("I")) {
                    int n = Integer.parseInt(st.nextToken());
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.size()  == 0) continue;
                    int n = Integer.parseInt(st.nextToken());
                    int num;
                    if (n == 1) {  // 최댓값 삭제
                        num = map.lastKey();
                    } else {  // 최솟값 삭제
                        num = map.firstKey();
                    }
                    if (map.put(num, map.get(num) - 1) == 1) {
                        map.remove(num);
                    }
                }
            }
            if (map.size() == 0) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}