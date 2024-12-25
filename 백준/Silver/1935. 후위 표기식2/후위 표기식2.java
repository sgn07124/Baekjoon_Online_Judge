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

        int N = Integer.parseInt(br.readLine());
        String prefix = br.readLine();

        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            // 알파벳 - 'A' == arr 의 인덱스 이므로
            // 알파벳이 온 경우에는 해당 알파벳과 매칭되는 숫자를 arr에서 뽑아서 stack에 push()
            if ('A' <= ch && ch <= 'Z') {
                double d = arr[ch - 'A'];
                stack.push(d);
            }
            // 연산자 기호이면 pop()을 2번 하여 뽑은 원소를 해당 연산자 기호에 대하여 계산을 진행 후 다시 stack에 push() 한다.
            else {
                double d1 = stack.pop();
                double d2 = stack.pop();
                double result = 0.0;
                switch (ch) {
                    case '+' :
                        result = d2 + d1;
                        break;
                    case '-' :
                        result = d2 - d1;
                        break;
                    case '*' :
                        result = d2 * d1;
                        break;
                    case '/' :
                        result = d2 / d1;
                        break;
                }
                stack.push(result);
            }
        }
        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();
    }
}