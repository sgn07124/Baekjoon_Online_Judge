import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();  // 변경 가능한 문자열

        int n = sc.nextInt();

        List<Integer> li = new ArrayList<>();  // list

        for (int i = 0; i < n; i++) {
            li.add(sc.nextInt());
        }
        Collections.sort(li);  // 오름차순

        for (Integer e : li) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }
}