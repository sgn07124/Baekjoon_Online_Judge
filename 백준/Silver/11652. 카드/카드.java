import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws  IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new LinkedHashMap<>();

        int max = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());

            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }

            if (map.get(card) > max) {  // result에 가장 많은 카드의 번호 저장하고, max에 가장 많은 카드 개수 저장
                result = card;
                max = map.get(card);
            } else if (map.get(card) == max) {  // 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
                result = Math.min(card, result);
            }
        }
        System.out.println(result);
    }
}