import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String sn = sc.next();  // 연이어서 문자를 한 번에 가져오니까 next() 사용
        char[] cn = sn.toCharArray();  // toCharArray() : String 문자열을 char형 배열로 바꿔서 반환해주는 메서드
        int sum = 0;
        for(int i = 0; i < cn.length; i++) {
            sum += cn[i] - '0';  // 아스키코드 cn[i]의 문자 - '0'(80) = (int)
        }
        System.out.println(sum);

    }
}