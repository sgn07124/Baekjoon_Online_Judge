
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];  // 정렬  2 4 -10 4 -9
        int[] sub = new int[n];  // 비교
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();  // map
        int cnt = 0;
        StringBuilder sb = new StringBuilder();  // 문자열(key, 공백) 합치려고 사용

        for (int i = 0; i < n; i++) {
            arr[i] = sub[i] = sc.nextInt();
        }

        Arrays.sort(arr);  // arr 오름차순으로 정렬  -10 -9 2 4 4

        for (int i : arr) {
            if (!map.containsKey(i)) {  // [0,-10], [1, -9], [2, 2], [3, 4]
                map.put(i, cnt);
                cnt++;
            }
        }

        for (int key : sub) {  // sub의 각 값을 map의 value 값에 매칭해서 map의 key값을 get으로 가져와서 sb에 추가
            sb.append(map.get(key)).append(" ");
        }

        System.out.println(sb);

    }
}