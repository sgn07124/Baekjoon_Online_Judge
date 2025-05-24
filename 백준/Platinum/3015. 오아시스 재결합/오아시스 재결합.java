import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        long answer = 0;
        
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            Node node = new Node(now, 1);
            
            // stack.peek() 중 now 보다 작거나 같은 것들은 pop()
            while (!stack.isEmpty() && stack.peek().height <= now) {
                Node prev = stack.pop();
                answer += prev.count;
                if (prev.height == now) {
                    node.count += prev.count;
                }
            }
            
            // stack.peek()이 now보다 큰게 인접해있는 경우도 추가
            if (!stack.isEmpty()) answer++;
            stack.push(node);
        }
        System.out.println(answer);
    }
    public static class Node {
        int height;
        long count;
        public Node(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}