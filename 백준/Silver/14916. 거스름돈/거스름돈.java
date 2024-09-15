
import java.io.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            if (n % 5 == 0) {
                cnt += n / 5;
                bw.write(cnt + "");
                break;
            } else {
                n -= 2;
                cnt++;
            }
            if (n < 0) {
                bw.write("-1");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
