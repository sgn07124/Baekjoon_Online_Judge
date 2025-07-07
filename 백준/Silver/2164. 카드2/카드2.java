import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Deque<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        while (q.size() != 1) {
            q.pop();

            q.add(q.pop());
        }

        System.out.println(q.poll());

    }
}