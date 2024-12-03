import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String [] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 같으면? 사전순으로 정렬
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        // 중복되는 수는 건너뛰면서 출력
        bw.write(words[0] + "\n");
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i-1])) {
                bw.write(words[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}