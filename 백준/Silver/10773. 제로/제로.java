import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        while (k-- > 0) {
        	int n = Integer.parseInt(br.readLine());
        	
        	if (n == 0) {
        		stack.pop();
        	} else {
        		stack.push(n);
        	}
        }
        int size = stack.size();
        int sum = 0;
        
        for (int i = 0; i < size; i++) {
        	sum += stack.pop();
        }
        System.out.println(sum);
    }
}