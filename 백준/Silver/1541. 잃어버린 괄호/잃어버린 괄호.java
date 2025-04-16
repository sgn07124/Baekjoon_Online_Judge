import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
30-70-20+40-10+100+30-35
["30", "70", "20+40", "10+100+30", "35"]
30-70-(20+40)-(10+100+30)-35
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for (String s : line) {
            int temp = 0;

            String[] addition = s.split("\\+");

            for (String value : addition) {
                temp += Integer.parseInt(value);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}