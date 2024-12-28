
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (maxHeap.isEmpty() && x == 0) {
                bw.write(0 + "\n");
            } else if (x > 0) {
                maxHeap.add(x);
            } else {
                // maxHeap이 비어있지 않고 x가 0인 경우
                bw.write(maxHeap.poll() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}