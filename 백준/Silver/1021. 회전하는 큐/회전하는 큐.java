
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> deque = new LinkedList<>();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 큐의 크기 (1 ~ N)
        int M = Integer.parseInt(st.nextToken());  // 뽑으려는 숫자의 개수

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        int [] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            // 뽑고자 하는 숫자의 위치(index) 찾기
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if (deque.size() % 2 == 0) {
                // 만약 현재 덱의 원소가 짝수 개라면 중간 지점을 현재 덱의 절반 크기에서 1 감소 시킨다.
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }

            // 중간 지점 도는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if (target_idx <= half_idx) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다 (2번 연산)
                for (int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.addLast(temp);
                    cnt++;
                }
            }
            // 중간 지점보다 원소의 위치가 뒤에 있을 경우
            else {
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    cnt++;
                }
            }
            deque.pollFirst();  // 연산이 끝나면 앞 원소를 삭제 (1번 연산)
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}