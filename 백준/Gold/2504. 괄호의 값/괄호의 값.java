
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int answer = 0;
        int cnt = 1;
        for (int i = 0; i < line.length(); i++) {
            char cur = line.charAt(i);

            if (cur == '(') {  // '('를 만나면 stack에 해당 기호를 넣고 2를 곱해준다.
                stack.push(cur);
                cnt *= 2;
            } else if (cur == '[') {  // '['를 만나면 stack에 해당 기호를 넣고 3을 곱해준다.
                stack.push(cur);
                cnt *= 3;
            } else {
                // ')'를 만났을 때,
                if (cur == ')') {
                    // stack이 비어있거나, stack.peek()이 '('가 아니면 올바른 괄호가 아니므로 에러 처리
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    // 이전 값이 '('이면 지금까지 저장해놓은 값을 answer에 저장
                    if (line.charAt(i - 1) == '(') {
                        answer += cnt;
                    }
                    // 괄호가 닫힐 때마다 저장해둔 값들을 정리
                    stack.pop();
                    cnt /= 2;
                } else if (cur == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if (line.charAt(i - 1) == '[') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag || !stack.isEmpty()) {
            bw.write(0 + "");
        } else {
            bw.write(answer + "");
        }
        bw.flush();
        bw.close();
    }
}