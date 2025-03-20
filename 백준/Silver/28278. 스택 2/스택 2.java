
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("1")){
                stack.addFirst(Integer.parseInt(st.nextToken()));
            }else if(command.equals("2")){
                sb.append(stack.isEmpty() ? -1 : stack.pollFirst()).append("\n");
            }else if(command.equals("3")){
                sb.append(stack.size()).append("\n");
            }else if(command.equals("4")){
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            }else if(command.equals("5")){
                sb.append(stack.isEmpty()? -1 : stack.getFirst()).append("\n");
            }
        }
        System.out.println(sb);
    }
}