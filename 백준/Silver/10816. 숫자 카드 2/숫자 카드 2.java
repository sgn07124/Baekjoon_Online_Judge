import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());  // 상근이가 가지고 있는 숫자 카드의 개수
        st = new StringTokenizer(br.readLine());
        int [] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());  // 상근이가 가지고 있어야 하는 카드의 수
        st = new StringTokenizer(br.readLine());
        while (M -- > 0) {
            int x = Integer.parseInt(st.nextToken());
            // 1. x 이상의 값이 처음으로 나타나는 위치를 구한다.
            int lowerBoundIndex = findLowerBoundIndex(cards, x);

            // 2. x 초과의 값이 처음으로 나타나는 위치를 구한다.
            int upperBoundIndex = findUpperBoundIndex(cards, x);

            // 3. 두 값을 이용해 x의 개수를 센다.
            bw.write((upperBoundIndex - lowerBoundIndex) + " ");
        }
        bw.flush();
        bw.close();
    }

    private static int findLowerBoundIndex(int[] arr, int x) {
        // x 이상의 값이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) l = m + 1;
            else {
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }

    private static int findUpperBoundIndex(int[] arr, int x) {
        // x 초과의 값이 처음으로 나타나는 위치
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x)
                l = m + 1;
            else {
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }
}