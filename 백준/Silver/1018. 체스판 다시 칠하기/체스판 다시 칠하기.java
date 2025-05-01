import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean [][] arr;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else
                    arr[i][j] = false;
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    private static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean start = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색이 아닌 경우
                if (arr[i][j] != start) {
                    count++;
                }

                // 다음 칸은 색이 바뀌므로 값을 반대로 바꿔줘야 함.
                start = !start;
            }
            start = !start;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}