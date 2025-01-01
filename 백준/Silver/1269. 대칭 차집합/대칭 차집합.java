import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int x = Integer.parseInt(st.nextToken());
            setA.add(x);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int x = Integer.parseInt(st.nextToken());
            setB.add(x);
        }
        int cnt = 0;
        for (int num : setA) {
            if (!setB.contains(num)) cnt++;
        }
        for (int num : setB) {
            if (!setA.contains(num)) cnt++;
        }
        System.out.println(cnt);
    }
}