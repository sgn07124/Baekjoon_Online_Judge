import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 연병장의 크기
        int M = Integer.parseInt(st.nextToken());  // 조교의 수

        int [] origin = new int[N + 1];  // 연병장 각 칸의 높이
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int [] delta = new int[N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // 1. 각 지시에 따른 변화량 delta를 기록한다. (delta[i]: [i:N]까지 적용되는 변화량
            delta[a] += k;
            delta[b + 1] -= k;
        }

        // 2. 각 칸부터의 변화량을 각 칸에 적용한다.
        int [] accDelta = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        // 3. 변화량이 적용된 각 칸의 높이를 출력한다.
        for (int i = 1; i <= N; i++) {
            bw.write(origin[i] + accDelta[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}