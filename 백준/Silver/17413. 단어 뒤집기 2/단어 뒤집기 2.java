import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                // stack이 비어있지 않으면 기존 스택에 남아있던 문자들을 다 꺼내서 sb에 저장
                while (!stack.isEmpty()) sb.append(stack.pop());
                flag = true;  // 열림
            } else if (str.charAt(i) == '>') {
                flag = false;  // 닫힘
                sb.append(str.charAt(i));
                continue;
            }

            // flag == true 이면, '>' 가 나올 때까지 그대로 출력 (< > 내의 문자는 그대로 출력)
            if (flag == true) sb.append(str.charAt(i));
            // flag == false 이면, 괄호 이외의 문자를 처리 (이외의 문자는 뒤집어서 출력해야 됨)
            else if (flag == false) {
                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else stack.push(str.charAt(i));
            }
            if (i == str.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}