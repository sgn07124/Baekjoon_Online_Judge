import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String [][] recoreds = new String[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            recoreds[i][0] = st.nextToken();
            recoreds[i][1] = st.nextToken();
        }

        // 1. 이름 순서에 따라 춟입 기록을 차례로 정렬한다.
        Arrays.sort(recoreds, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2[0].compareTo(o1[0]);  // 내림차순 (사전 역순)
            }
        });

        // 2. 각 사원마다 마지막 기록이 enter라면, 출력한다. (사전 역순)
        for (int i = 0; i < N - 1; i++) {
            if (!recoreds[i][0].equals(recoreds[i + 1][0]) && recoreds[i][1].equals("enter")) {
                bw.write(recoreds[i][0] + "\n");
            }
        }
        if (recoreds[N - 1][1].equals("enter")) {
            bw.write(recoreds[N - 1][0] + "\n");
        }

        bw.flush();
        bw.close();
    }
}