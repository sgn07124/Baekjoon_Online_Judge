
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C, cnt = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = pow(A, B, C);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    /**
     * 분할 정복을 이용한 거듭제곱 계산 함수로 a^b를 계산하면서 중간에 c로 나눈 나머지를 유지하여 숫자가 너무 커지지 않도록 방지(BufferOverflow)
     */
    public static long pow(long a, long b, long c) {
        // 지수가 0인 경우 (a^0=1) -> 종료
        if (b == 0) return 1;

        // 재귀로 b를 반으로 나누어 계산 -> 문제를 더 작은 문제로 나누어 해결(분할 정복)
        long half = pow(a, b / 2, c);

        // half * half는 a^(b/2) * a^(b/2) = a^b의 형태가 됨.
        // 이를 c로 모듈러 연산하여 큰 수가 되는 것을 방지
        long temp = (half * half) % c;

        // b가 짝수일 경우, a^b를 그대로 반환(temp)
        if (b % 2 == 0) {
            return temp;
        } else {
            // b가 홀수일 경우, a를 추가로 곱한 후 c로 나눈 나머지를 계산하여 반환. -> a^b = a * a^(b-1)의 형태를 따름. 
            // 중간에 overflow를 방지하기 위해 모듈러 연산을 함
            return (temp * a) % c;
        }
    }
}
