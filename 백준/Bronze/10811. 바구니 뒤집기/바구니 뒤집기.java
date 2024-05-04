import java.util.Scanner;
import java.util.Collections;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr [] = new int[N];
        
        for (int a = 0; a < N; a++) {
            arr[a] = a+1;
        }
        int tmp = 0;
        for (int a = 0; a < M; a++) {
            int i = sc.nextInt() - 1;  // 1 → 0번째 배열
            int j = sc.nextInt() - 1;  // 4 → 3번째 배열
            
            while (i<j) {  // (0,3)(1,2) 교환
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        for (int a = 0; a < N; a++) {
            System.out.print(arr[a] + " ");
        }
    }
}