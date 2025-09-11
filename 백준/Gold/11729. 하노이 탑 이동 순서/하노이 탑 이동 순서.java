import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        sb.append((int) (Math.pow(2, N) - 1)).append("\n");
        
        Hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
    
    private static void Hanoi(int n, int start, int mid, int to) {
        // n: 원판의 개수 / start: 출발지 / mid: 옮기기 위해 이동해야 하는 지점 / to: 목적지
        // 이동할 원판이 1개인 경우
        if (n == 1) {
            sb.append(start + " " + to).append("\n");
            return;
        }
        
        // A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(n - 1, start, to, mid);
    
		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		sb.append(start + " " + to).append("\n");
    
		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(n - 1, mid, start, to);
    }
}