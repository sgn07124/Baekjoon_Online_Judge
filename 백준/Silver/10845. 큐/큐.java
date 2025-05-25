import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command);
            String op = st.nextToken();
            
            switch(op) {
                case "push":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop":
                    if (!deque.isEmpty()) System.out.println(deque.pollFirst());
                    else System.out.println(-1);
                    break;
                    
                case "size":
                    System.out.println(deque.size());
                    break;
                    
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                    
                case "front":
                    if (!deque.isEmpty()) System.out.println(deque.peekFirst());
                    else System.out.println(-1);
                    break;
                    
                case "back":
                    if (!deque.isEmpty()) System.out.println(deque.peekLast());
                    else System.out.println(-1);
                    break;
            }
        }
    }
}