import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        partition(0, 0, N);
        System.out.println(sb);

    }

    private static void partition(int row, int col, int size) {
        if (dataCheck(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        partition(row, col, newSize);  // 왼쪽 위
        partition(row, col + newSize, newSize);  // 오른쪽 위
        partition(row + newSize, col, newSize);  // 왼쪽 아래
        partition(row + newSize, col + newSize, newSize);	 // 오른쪽 아래

        sb.append(')');
    }

    private static boolean dataCheck(int row, int col, int size) {
        int data = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (data != board[i][j]) {  // 탐색 좌표가 첫 좌표(data)와 다르면 리턴
                    return false;
                }
            }
        }
        return true;
    }
}