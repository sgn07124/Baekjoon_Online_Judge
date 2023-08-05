import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                n -= 5;
                cnt++;
            } else if (n % 3 == 0) {
                n -= 3;
                cnt++;
            } else if (n > 5) {
                n -= 5;
                cnt++;
            } else {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}
