import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        String start = "ABCDEF";
        char [] element = { 'A', 'F', 'C'};

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            boolean check = true;

            // 첫 글자 검사
            if (start.indexOf(input.charAt(0)) < 0) {
                sb.append("Good\n");
                continue;
            }

            // A, F, C
            int cur = input.charAt(0) == 'A' ? 0 : 1;
            for (int j = 0; j < element.length; j++) {
                if (input.charAt(cur) != element[j]) {
                    sb.append("Good\n");
                    check = false;
                    break;
                } else {
                    for (int l = cur; l < input.length(); l++) {
                        if (input.charAt(l) != element[j]) {
                            cur = l;
                            break;
                        } else cur++;
                    }
                }
            }

            // 마지막 글자
            if (check) {
                if (cur == input.length()) {
                    sb.append("Infected!\n");
                } else if (input.length() - cur > 1) {
                    sb.append("Good\n");
                } else {
                    if (start.indexOf(input.charAt(cur)) < 0) {
                        sb.append("Good\n");
                    } else {
                        sb.append("Infected!\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}