import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            // Arrays.binarySearch(Array, Value): (값이 존재하지 않으면 -1을 반환하고 값이 존재하면 index를 반환함
            int idx = Arrays.binarySearch(A, x);
            int ans = idx >= 0 ? 1 : 0;
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}