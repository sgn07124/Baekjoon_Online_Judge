import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char [] arr;
    static char [] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        password(0, 0);
        System.out.println(sb);
    }

    static void password(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                for (char c : result) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }
        for (int i = start; i < C; i++) {
            result[depth] = arr[i];
            password(i + 1, depth + 1);
        }
    }

    static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char c : result) {  // 결과 배열과 비교해야됨.. 이 부분 틀렸음
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else ja++;
        }
        if (mo >= 1 && ja >= 2) return true;
        return false;
    }
}