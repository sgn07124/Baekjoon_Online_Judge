import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<String> leftStack = new Stack<String>();
        Stack<String> rightStack = new Stack<String>();

        // 처음 커서는 문장의 맨 뒤에서 시작하기 때문에 왼쪽 스택에 초기 문자를 모두 넣어줌 (ex. abc|)
        String[] arr = str.split("");
        for(String s : arr) { //Enhanced For Loop 사용
            leftStack.push(s);
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());  // cursor을 왼쪽으로 한 칸 이동
                    break;

                case 'D':
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());  // cursor을 오른쪽으로 한 칸 이동
                    break;

                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop();  // cursor 왼쪽의 문자를 삭제
                    break;

                case 'P':
                    leftStack.push(String.valueOf(command.charAt(2)));  // $ 문자를 커서 왼쪽에 추가
                    break;

                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        while (!rightStack.isEmpty()) sb.append(rightStack.pop());
        System.out.println(sb);
    }
}