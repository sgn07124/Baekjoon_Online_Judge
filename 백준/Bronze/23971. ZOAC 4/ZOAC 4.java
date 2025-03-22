
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테이블이 행마다 W개씩 H행에 걸쳐 있음 -> H행 W열
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 함
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int f = (H - 1) / (N + 1) + 1;
        int s = (W - 1) / (M + 1) + 1;

        System.out.println(f * s);
    }
}