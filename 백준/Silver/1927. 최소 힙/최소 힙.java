import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> minHeap = new PriorityQueue<>();  // 최소 힙 -> peek()가 최솟값

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (minHeap.isEmpty() && x == 0) {
                bw.write("0\n");
            } else if (x > 0) {
                minHeap.add(x);
            } else if (!minHeap.isEmpty() && x == 0){
                bw.write(minHeap.poll() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}