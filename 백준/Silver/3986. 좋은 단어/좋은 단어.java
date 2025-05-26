import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            stack = new Stack<>();

            for (int j = 0; j < line.length(); j++) {
                char now = line.charAt(j);
                if (!stack.isEmpty() && stack.peek() == now) {
                    stack.pop();
                } else {
                    stack.push(now);
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}