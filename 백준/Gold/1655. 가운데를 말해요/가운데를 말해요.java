
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());  // maxHeap
        Queue<Integer> maxPQ = new PriorityQueue<>();  // minHeap

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (minPQ.size() == maxPQ.size()) {
                minPQ.add(x);
            } else {
                maxPQ.add(x);
            }

            // 중앙값은 maxPQ의 peek()보다 작은 값
            if (!minPQ.isEmpty() && !maxPQ.isEmpty() && minPQ.peek() > maxPQ.peek()) {
                int temp = minPQ.poll();
                minPQ.add(maxPQ.poll());
                maxPQ.add(temp);
            }
            sb.append(minPQ.peek()).append("\n");
        }
        System.out.println(sb);
    }
}