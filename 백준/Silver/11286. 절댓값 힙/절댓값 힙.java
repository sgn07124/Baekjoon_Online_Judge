
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 절댓값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
                if (Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                }
                // 절댓값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
                else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (minHeap.isEmpty() && x == 0) {
                bw.write("0\n");
            } else if (x != 0) {
                minHeap.add(x);
            } else if (!minHeap.isEmpty() && x == 0) {
                bw.write(minHeap.poll() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
