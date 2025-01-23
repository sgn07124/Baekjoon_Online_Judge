import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(recursion(0, 0, N));
    }

    static int recursion(int row, int col, int size) {
        if (size == 2) {  // 마지막 결과 구하는 과정: 2x2인 경우
            int arr[] = new int[4];
            int idx = 0;
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    arr[idx++] = board[i][j];
                }
            }
            Arrays.sort(arr);
            return arr[2];  // 두 번째로 큰 수 리턴
        } else {
            int arr[] = new int[4];
            size = size / 2;

            arr[0] = recursion(row, col, size);
            arr[1] = recursion(row, col + size, size);
            arr[2] = recursion(row + size, col, size);
            arr[3] = recursion(row + size, col + size, size);

            Arrays.sort(arr);
            return arr[2];
        }
    }
}