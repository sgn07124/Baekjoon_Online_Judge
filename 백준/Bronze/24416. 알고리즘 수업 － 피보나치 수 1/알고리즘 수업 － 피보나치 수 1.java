
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    static int [] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        cnt = 0;
        fib(N);
        sb.append(cnt).append(" ");
        cnt = 0;
        f = new int[N + 1];
        fibonacci(N);
        sb.append(cnt);
        System.out.println(sb);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            cnt++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}