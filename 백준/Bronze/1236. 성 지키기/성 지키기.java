
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char [][] palace = new char[n][m];

        for (int i = 0; i < n; i++) {
            palace[i] = sc.next().toCharArray();
        }

        // 1. 각 행/열에 대해 경비원이 있는지 확인한다.
        int existRowCount = 0;
        for (int i = 0; i < n; i++) {
            boolean exist = false;
            for (int j = 0; j < m; j++) {
                if (palace[i][j] == 'X') {
                    exist = true;
                    break;
                }
            }
            // 경비원이 있으면?
            if (exist) existRowCount++;
        }

        int existColCount = 0;
        for (int i = 0; i < m; i++) {
            boolean exist = false;
            for (int j = 0; j < n; j++) {
                if (palace[j][i] == 'X') {
                    exist = true;
                    break;
                }
            }
            // 경비원이 있으면?
            if (exist) existColCount++;
        }

        // 2. 보호받지 못하는 행/열의 개수를 구한다.
        int needRowCnt = n - existRowCount;
        int needColCnt = m - existColCount;

        // 3. 둘 중 큰 값을 구한다.
        System.out.println(Math.max(needRowCnt, needColCnt));
    }
}