import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String [] now = sc.nextLine().split(":");
        String [] sal = sc.nextLine().split(":");

        int nowHour = Integer.parseInt(now[0]);
        int nowMinute = Integer.parseInt(now[1]);
        int nowSecond = Integer.parseInt(now[2]);

        int salHour = Integer.parseInt(sal[0]);
        int salMinute = Integer.parseInt(sal[1]);
        int salSecond = Integer.parseInt(sal[2]);

        int nowFullSecond = nowHour * 3600 + nowMinute * 60 + nowSecond;
        int salFullSecond = salHour * 3600 + salMinute * 60 + salSecond;

        int result = salFullSecond - nowFullSecond;
        if (result <= 0) {
            result += 24 * 3600;
        }

        int resultHour = result / 3600;
        int resultMinute = (result % 3600) / 60;
        int resultSecond = result % 60;

        System.out.println(String.format("%02d:%02d:%02d", resultHour, resultMinute, resultSecond));
    }
}
