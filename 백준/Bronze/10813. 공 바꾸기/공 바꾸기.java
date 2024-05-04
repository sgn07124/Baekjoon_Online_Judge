import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int arr [] = new int [N];
        int i, j;
        for (int t = 0; t < N; t++) {
            arr[t] = t+1;
        }
        for (int a = 0; a < M; a++) {
            int tmp = 0;
            i = sc.nextInt()-1;
            j = sc.nextInt()-1;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        for (int c = 0; c < N; c++) {
            System.out.print(arr[c] + " ");
        }
        
    }
}