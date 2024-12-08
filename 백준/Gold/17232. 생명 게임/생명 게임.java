import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 세로 길이
        int M = Integer.parseInt(st.nextToken());  // 가로 길이
        int T = Integer.parseInt(st.nextToken());  // 관찰 시간

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());  // 주위의 기준이 되는 정수
        int a = Integer.parseInt(st.nextToken());  // 각 칸의 다음 칸을 결정하는 정수
        int b = Integer.parseInt(st.nextToken());

        char [][] map = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        while (T-- > 0) {
            int [][] acc = getPrefixSum(map);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i, j, K);
                    if (map[i][j] == '*') {
                        nearAlive--; // 현재 본인은 제외
                        if (nearAlive < a || nearAlive > b) {
                            map[i][j] = '.'; // 사망
                        }
                    } else if (nearAlive > a && nearAlive <= b) {
                        map[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static int getRangeSum(int[][] acc, int r, int c, int k) {
        int r1 = Math.max(r - k, 1);
        int c1 = Math.max(c - k, 1);
        int r2 = Math.min(r + k, acc.length - 1);
        int c2 = Math.min(c + k, acc[0].length - 1);
        return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
    }

    private static int[][] getPrefixSum(char[][] map) {
        int [][] acc = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                acc[i][j]= acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + (map[i][j] == '*' ? 1 : 0);
            }
        }
        return acc;
    }
}
