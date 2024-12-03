
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] h = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            h[i] = Integer.parseInt(br.readLine());
            sum += h[i];
        }

        int [] ans = new int[7];
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                // 전체 난쟁이(sum)에서 2명을 제외한 값이 100이면?
                if (sum - h[i] - h[j] == 100) {
                    int ansIndex = 0;
                    for (int k = 0; k < 9; k++) {
                        // i와 j의 난쟁이를 제외한 나머지 난쟁이라면?
                        if (k != i && k != j) {
                            // ans[]에 난쟁이의 키를 저장
                            ans[ansIndex++] = h[k];
                        }
                    }
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        Arrays.sort(ans);

        for (int i = 0; i < 7; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
