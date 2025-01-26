import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[50001];
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            for (int j = 0; j * j <= i; j++) {
                arr[i] = Math.min(arr[i], 1 + arr[i - j * j]);  // 모든 경우 계산
            }
        }

        System.out.println(arr[n]);
    }
}