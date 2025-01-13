import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

         int N = Integer.parseInt(br.readLine());
         while (N-- > 0) {
             String str = br.readLine();
             Stack<String> leftStack = new Stack<String>();
             Stack<String> rightStack = new Stack<String>();
             String[] arr = str.split("");

             for (int i = 0; i < arr.length; i++) {
                 switch (arr[i]) {
                     case "<" :
                         // 커서를 왼쪽으로 이동
                         if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                         break;

                     case ">" :
                         // 커서를 오른쪽으로 이동
                         if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                         break;

                     case "-" :
                         // 백스페이스
                         if (!leftStack.isEmpty()) leftStack.pop();
                         break;

                     default:
                         // 대문자, 소문자, 숫자를 입력한 경우, 커서의 왼쪽 스택에 추가
                         leftStack.push(arr[i]);
                         break;
                 }
             }
             while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
             while (!rightStack.isEmpty()) sb.append(rightStack.pop());
             sb.append('\n');
         }
        System.out.println(sb);
    }
}