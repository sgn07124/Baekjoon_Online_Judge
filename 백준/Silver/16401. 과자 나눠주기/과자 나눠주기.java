import java.util.*;
import java.io.*;

/**
 * 최대한 긴 과자
 * 모든 조카에게 같은 길이의 과자를 나눠줘야함
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());  // 조카의 수
        int n = Integer.parseInt(st.nextToken());  // 과자의 수
        
        int [] snacks = new int [n];
        int max = 0;
        int result = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snacks[i]);
        }
        
        // 최소 길이부터 최대 길이까지
        System.out.println(binarySearch(snacks, m, 1, max));
    }
    
    
    static int binarySearch(int[] snacks, int M, int left, int right) {
        int result = 0;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            int cnt = 0;

            for (int i = 0; i < snacks.length; i++) {
                cnt += snacks[i] / mid;
            }

            if (cnt >= M) {
            	// cnt가 조카수보다 같거나 많을 경우
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}