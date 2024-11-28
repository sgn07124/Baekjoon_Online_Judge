import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.next().toUpperCase();

        int [] count = new int[26];
        for (int i = 0; i < line.length(); i++) {
            count[line.charAt(i) - 'A']++;
        }

        int maxCount = 0;
        char maxAlp = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlp = (char) ('A' + i);
            } else if (count[i] == maxCount) {
                maxAlp = '?';
            }
        }

        System.out.println(maxAlp);
    }
}