import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        bw.write("<");
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                bw.write(queue.poll() + ">");
            } else if (cnt == K) {
                bw.write(queue.poll() + ", ");
                cnt = 1;
            } else {
                int peek = queue.poll();
                queue.add(peek);
                cnt++;
            }
        }
        bw.flush();
        bw.close();
    }
}