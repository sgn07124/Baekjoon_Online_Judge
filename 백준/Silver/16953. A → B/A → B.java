import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B));
    }

    private static int bfs(long start, long end) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(start);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long tmp = queue.poll();
                if (tmp == end) return cnt + 1;
                if (tmp * 2 <= end) queue.add(tmp * 2);  // 1번 연산
                if (tmp * 10 + 1 <= end) queue.add(tmp * 10 + 1);  // 2번 연산
            }
            cnt++;
        }
        return -1;
    }
}