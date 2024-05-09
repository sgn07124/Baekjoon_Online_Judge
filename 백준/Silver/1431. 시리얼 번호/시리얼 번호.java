import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /**
         * 1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
         * 2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저 온다.(숫자만 더함)
         * 3. 만약 1,2번 두 조건으로도 비교가 안되면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
         */

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String [] arr = new String [N];

        for (int i = 0; i < N; i++) {
            arr [i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {  // 1.
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {  // 문자열 길이만큼 돌리는데
                        if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {  // 문자열을 문자 단위로 자른게 숫자면
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));  // 정수로 변환해서 더하면서 자리합을 구함
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }
                    if (sum1 == sum2) {  // 2.
                        // 3. 사전순으로 비교 -> 오름차순
                        return o1.compareTo(o2);
                    } else {
                        // 2. A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저 온다.(숫자만 더함)
                        return sum1 - sum2;
                    }
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}