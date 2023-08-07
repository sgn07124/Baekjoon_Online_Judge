import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            if (n != 0) {
                st.push(n);
            } else if (n == 0) {
                st.pop();
            }
            // System.out.println("st : " + st);
        }
        // System.out.println("st : " + st);
        int size = st.size();
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += st.pop();
        }
        System.out.println(total);
    }
}
