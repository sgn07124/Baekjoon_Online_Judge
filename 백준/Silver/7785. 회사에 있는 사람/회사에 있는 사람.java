import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>();  // TreeSet: 순서를 가짐 (오름차순)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter"))  // 집합에 추가
                set.add(name);
            else set.remove(name);  // 집합에서 제거
        }

        String [] orderedName=  set.toArray(new String[set.size()]);
        for (int i = orderedName.length - 1; i >= 0; i--) {
            bw.write(orderedName[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}