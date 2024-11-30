import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        boolean [] exist = new boolean[1000001];
        for (int i = 0; i < N; i++) {
            exist[arr[i]] = true;
        }

        int ans  = 0;

        for (int i = 0; i < N; i++) {
            int pairValue = X - arr[i];
            if (0 <= pairValue && pairValue <= 1000000) {
                ans += exist[pairValue] ? 1 : 0;
            }
        }
        System.out.println(ans / 2);
    }
}