import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        Stack<Integer> stack = new Stack<>();
        
        int ans = 0;
        
        for (int i = 0; i < line.length(); i++) {
            char pos = line.charAt(i);
            
            if (pos == 'H') {
                stack.push(1);
            } else if (pos == 'C') {
                stack.push(12);
            } else if (pos == 'O') {
                stack.push(16);
            } else if (pos == '(') {
                stack.push(-1);
            } else if (pos == ')') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    sum += stack.pop();  // '(' 까지의 스택 내부의 값들을 더한다.
                }
                stack.pop(); // '(' 제거
                stack.push(sum);
            } else {
                // 숫자인 경우
                int peek = stack.pop();
                stack.push(peek * (pos - '0'));
            }
        }
        
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        
        System.out.println(ans);
    }
}