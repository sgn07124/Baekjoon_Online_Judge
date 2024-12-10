import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = -1;
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // A + B + C = X  ->  A + B = X - C
        // 1. A + B의 집합을 만든다.
        int [] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);

        // 2. 모든 X - C에 대해 A + B 집합에 존재하는지 확인한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {  // j가 0부터 시작하는 이유는 arr[3] - arr[5]와 arr[5] - arr[3]의 값은 다르기 때문
                int target = arr[i] - arr[j];
                if (isExist(sums, target)) {
                //if (Arrays.binarySearch(sums, target) >= 0) { // binarySearch를 사용해도 됨
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        // 3. A + B = X - C를 만족하는 X 중 최대값을 출력한다.
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    private static boolean isExist(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < target) l = m + 1;
            else if (arr[m] > target) r = m - 1;
            else return true;
        }
        return false;
    }
}