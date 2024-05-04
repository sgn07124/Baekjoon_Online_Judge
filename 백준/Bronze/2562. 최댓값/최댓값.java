import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int arr[] = new int [9];
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                cnt = i+1;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
        
    }
}