import java.util.Scanner;

public class Main {

    public static int [] getAlphabetCount(String str) {
        int [] count = new int [26];
        for (int i = 0;  i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int [] countA = getAlphabetCount(a);
        int [] countB = getAlphabetCount(b);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(countA[i] - countB[i]);  // 절대값을 더함
        }
        //for (int i = 0; i < 26; i++) {
        //    if (countA[i] > countB[i]) {
        //        ans += countA[i] - countB[i];
        //    } else if (countA[i] < countB[i]) {
        //        ans += countB[i] - countA[i];
        //    }
        //}

        System.out.println(ans);
    }
}