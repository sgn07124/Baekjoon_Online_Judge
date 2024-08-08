
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int [][] arr;
    static int [] answer = new int[3];  // -1, 0, 1


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        for (int i = 0; i < 3; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void cut(int x, int y, int size) {
        // 다 같은 숫자면 더하기
        if (numCheck(x, y, size)) {
            if (arr[x][y] == -1) {
                answer[0]++;
            } else if (arr[x][y] == 0) {
                answer[1]++;
            } else {
                answer[2]++;
            }
        } else {  // 다른 숫자가 포함되어 있으면 9분할 진행
            int newSize = size / 3;

            cut(x, y, newSize);
            cut(x, y + newSize, newSize);
            cut(x, y + newSize * 2, newSize);

            cut(x + newSize, y, newSize);
            cut(x + newSize, y + newSize, newSize);
            cut(x + newSize, y + newSize * 2, newSize);
            cut(x + newSize * 2, y, newSize);
            cut(x + newSize * 2, y + newSize, newSize);
            cut(x + newSize * 2, y + newSize * 2, newSize);
        }
    }

    public static boolean numCheck(int x, int y, int size) {
        int start = arr[x][y];
        boolean check = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (start != arr[i][j]) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}
