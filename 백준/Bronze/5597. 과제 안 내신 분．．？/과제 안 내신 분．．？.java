import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int arr [] = new int [30];  // 학생이 30명
        
        for (int i = 0; i < 28; i++) {  // 28명이 출석
            int x = sc.nextInt();
            arr[x-1] = 1;  // 학생의 출석번호에 Flag값 1로 설정(기본값:0)
        }
        
        for (int i = 0; i < 30; i++) {
            if (arr[i] != 1) {  // Flag 값이 0이면 결석
                System.out.println(i+1);
            }
        }
    }
}