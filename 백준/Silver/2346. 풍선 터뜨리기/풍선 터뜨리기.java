
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<int []> deque = new ArrayDeque<>();
        String [] arr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            deque.addLast(new int[]{i + 1, Integer.parseInt(arr[i])});
        }

        while (!deque.isEmpty()) {
            int [] current = deque.pollFirst();
            int number = current[0];
            int move = current[1];

            bw.write(number + " ");

            if (deque.isEmpty()) break;
            if (move > 0) {
                // 오른쪽으로 이동
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }
            else {
                // 왼쪽으로 이동
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        bw.flush();
        bw.close();
    }
}