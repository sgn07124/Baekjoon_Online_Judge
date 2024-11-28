import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String search = sc.nextLine();


        int cnt = 0;

        for (int i = 0; i <= input.length() - search.length(); i++) {
            String comp = input.substring(i, i + search.length());
            if (search.equals(comp)) {
                cnt++;
                i += search.length() - 1;
            }
        }
        System.out.println(cnt);
    }
}