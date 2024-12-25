
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

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            // 열린 괄호면 스택에 추가
            if (input.charAt(i) == '(') {
                stack.add('(');
                continue;
            }
            if (input.charAt(i) == ')') {
                stack.pop();
                // 이전의 괄호가 열린 괄호이면 레이저이므로 열린 괄호는 막대의 개수니까 여기까지의 막대 개수를
                // 더해준다. (레이저로 절단)
                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    // 이전의 괄호가 닫힌 괄호이면 레이저가 아님 -> 막대의 끝 부분
                    // 하나의 막대를 마감하는 것이므로 1을 더해줌
                    result++;
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}