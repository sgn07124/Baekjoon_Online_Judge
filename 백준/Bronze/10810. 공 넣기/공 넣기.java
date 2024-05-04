import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int arr [] = new int [N];
        int i, j, k;
        for (int a = 0; a < M; a++) {
            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();
            for (int b = i; b <= j; b++) {
                arr[b-1] = k;
            }
        }
        for (int c = 0; c < N; c++) {
            System.out.print(arr[c] + " ");
        }
        
    }
}