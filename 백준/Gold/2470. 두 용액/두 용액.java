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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ansAbs = 2000000000;
        int ans1 = 0;
        int ans2 = 0;
        // 1. 첫 번째 용액에 대해 최적쌍이 되는 두 번째 용액을 찾는다.
        for (int i = 0; i < N - 1; i++) {
            int pairValue = findOptimalPairValue(arr, i + 1, N - 1, arr[i]);
            int abs = Math.abs(arr[i] + pairValue);
            if (abs < ansAbs) {
                ansAbs = abs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }

        // 2. 두 용액의 합이 0에 가장 가까운 쌍을 출력한다.
        bw.write(ans1 + " " + ans2);
        bw.flush();
        bw.close();
    }

    private static int findOptimalPairValue(int[] arr, int fromIndex, int toIndex, int value) {
        int optimalPairValue = arr[fromIndex];
        int optimalAbs = Math.abs(value + optimalPairValue);
        int l = fromIndex + 1, r = toIndex;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = value + arr[m];
            int sumAbs = Math.abs(sum);
            if (sumAbs < optimalAbs) {
                optimalPairValue = arr[m];
                optimalAbs = sumAbs;
            }
            if (sum < 0) l = m + 1;
            else if (sum > 0) r = m - 1;
            else return arr[m];
        }
        return optimalPairValue;
    }
}