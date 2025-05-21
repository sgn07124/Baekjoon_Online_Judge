import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 탑 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] heights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int height = heights[i];
            
            // 현재 탑보다 낮은 탑은 스택에서 제거
            while (!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();
            }

            // 스택이 비었으면 수신하는 탑이 없음 (0)
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            // 현재 탑을 스택에 push
            stack.push(new Top(i, height));
        }

        System.out.println(sb);
    }

    static class Top {
        int index;
        int height;

        Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}