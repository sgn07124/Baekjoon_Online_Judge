import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] board;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    private static void partition(int row, int col, int size) {

        if (colorCheck(row, col, size)) {
            // true -> 모두 같은 색상이므로 색상 카운트 후 리턴
            if (board[row][col] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;  // [size/2][size/2] -> 사등분

        // 재귀 호출
        partition(row, col, newSize);  // 2사분면
        partition(row, col + newSize, newSize);  // 1사분면
        partition(row + newSize, col, newSize);  // 3사분면
        partition(row + newSize, col + newSize, newSize);  // 4사분면
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];  // 첫 번째 칸을 기준으로 색상이 같은지 검사

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 첫 번째 칸의 색상과 탐색 칸의 색상이 다르면 리턴
                if (board[i][j] != color) return false;
            }
        }
        return true;
    }
}