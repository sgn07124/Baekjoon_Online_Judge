import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char [][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        star(0, N-1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void star(int r, int c, int N) {
        if (N == 3) { // k=0인 가장 작은 삼각형일 때 별찍기
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
            return;
        } else { // 큰 삼각형 세개로 다시 쪼갬
            int cut = N / 2;
            star(r, c, cut); // 제일 위에 삼각형
            star(r + cut, c - cut, cut); // 아래 왼쪽 삼각형
            star(r + cut, c + cut, cut); // 아래 오른쪽 삼각형
        }
    }
}