
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        /**
         * Ex) 1,2,3,4,5,6,7,8,9
         * minPQ에 1,2,3,4,5가 들어가고 maxPQ에 6,7,8,9가 들어간다고 할 때,
         * minPQ에서 peek()를 하면 가장 큰 수인 5가 나올 것이고 maxPQ에서 peek()를 하면 가장 작은 수인 6이 나온다.
         * 그러면 항상 minPQ과 maxPQ의 개수가 같거나, minPQ이 1개 더 많도록 유지한다면?
         * => 무조건 minPQ의 peek() 값이 중앙값이 된다.
         * 1. 홀수 번째는 항상 minPQ에 넣고, 짝수 번째는 항상 maxPQ에 넣는다.
         * 2. minPQ의 peek()은 maxPQ의 peek()보다 작아야 한다.
         *   -> maxPQ.peek() > minPQ.peek()이면 => minPQ의 peek()와 maxPQ의 peek()를 swap
         */

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            sb.append((M + 1) / 2);
            sb.append("\n");

            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());  // maxHeap, 작은 수
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();  // minHeap, 큰 수
            
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                // 입력 시 한 줄에 10개 입력
                if (i % 10 == 0) st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken());

                if (minPQ.size() == maxPQ.size()) {  // 홀수 번째는 항상 minPQ에 넣는다.
                    maxPQ.add(number);
                } else {  // 짝수 번째는 항상 maxPQ에 넣는다.
                    minPQ.add(number);
                }
                // minPQ의 peek()은 maxPQ의 peek()보다 작아야 한다.
                if (!minPQ.isEmpty() && !maxPQ.isEmpty() && maxPQ.peek() < minPQ.peek()) {
                    int max_H = minPQ.poll();
                    int min_H = maxPQ.poll();
                    maxPQ.add(max_H);
                    minPQ.add(min_H);
                }
                if (i % 2 == 0) {
                    sb.append(maxPQ.peek());
                    sb.append(" ");
                    cnt++;
                    if (cnt % 10 == 0) sb.append("\n");
                }
            }
            sb.append("\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}