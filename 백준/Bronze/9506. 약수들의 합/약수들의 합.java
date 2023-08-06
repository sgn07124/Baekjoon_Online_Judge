import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = 0;


        while(n != -1) {
            n = sc.nextInt();
            if(n==-1)break;
            boolean flag = false;
            int sum = 0;

            for (int i = 1; i <= n/2; i++) {  // 6의 경우 3까지만 돌리면 됨
                if (n % i == 0) {
                    sum += i;
                }
//                System.out.println("sum = " + sum + " i : " + i);

//                else  if (sum > n){  // 반례 : 7처럼 sum이 n보다 작은 수는 처리가 안됨
//                    System.out.println(n + " is NOT perfect.");
//                }
            }

            if (sum == n) {  // 완전수
                System.out.print(n + " = ");
                for (int j = 1; j <= n/2; j++) {
                    if (j == n/2) {
                        System.out.print(j);
                    } else if (n % j == 0) {
                        System.out.print(j + " + ");
                    }
                }
                flag = true;
                System.out.println();
            }
//            System.out.println("TEST");
            if(!flag){
                System.out.println(n + " is NOT perfect.");
            }

        }
    }
}