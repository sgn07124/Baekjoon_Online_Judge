import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < 20; i++) L.add(i + 1);
        int a = 0;

        while (m-- > 0) {
            String line = br.readLine();
            String [] split = line.split(" ");
            switch (split[0]) {
                case "add":
                    a = a | (1 << Integer.parseInt(split[1]));
                    break;

                case "remove":
                    a = a & ~(1 << Integer.parseInt(split[1]));
                    break;

                case "check":
                    if (0 < (1 << Integer.parseInt(split[1]) & a)) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "toggle":
                    if (0 < (1 << Integer.parseInt(split[1]) & a)) {
                        a = a & ~(1 << Integer.parseInt(split[1]));
                    } else {
                        a = a | (1 << Integer.parseInt(split[1]));
                    }
                    break;

                case "all":
                    a = a | (1 << 21) - 1;
                    break;

                case "empty":
                    a = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}