
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
        StringBuilder sb = new StringBuilder();

        char [] cal = br.readLine().toCharArray();

        Stack<Character> op = new Stack<>();  // 연산자를 담을 stack
        for (int i = 0; i < cal.length; i++) {
            // 연산식이 숫자이면 그대로 문자열에 저장한다.
            if (cal[i] >= 'A' && cal[i] <= 'Z') sb.append(cal[i]);
            else {
                if (cal[i] == '(') {
                    op.push(cal[i]);
                } else if (cal[i] == ')') {
                    // '('이 나올 때까지 연산자를 op에서 꺼내어 문자열에 담아준다.
                    while (!op.isEmpty() && op.peek() != '(') {
                        sb.append(op.pop());
                    }
                    if (!op.isEmpty()) op.pop();  // 이제 괄호처리는 위의 while에서 끝났으니 '('는 꺼내준다.
                } else {  // + - * / 연산자 일 경우
                    // 현재 연산자보다 연산자 스택에 담아둔 연산자(op.peek())의 우선순위가 더 높거나 같다면 먼저 꺼내어 출력한다.
                    while (!op.isEmpty() && isPriority(op.peek()) >= isPriority(cal[i])) {
                        sb.append(op.pop());
                    }
                    op.push(cal[i]);
                }
            }
        }
        while (!op.isEmpty()) {
            sb.append(op.pop());
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    public static int isPriority(char op) {
        if (op == '*' || op == '/') return 2;
        else if (op == '+' || op == '-') return 1;
        else return 0;  // '('를 만나면 더 이상 꺼내면 안되므로 '('의 우선순위를 가장 낮게 설정한다.
    }
}