
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> titles = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            titles.put(title, titles.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> title : titles.entrySet()) {
            String titleName = title.getKey();
            int count = title.getValue();
            if (count > maxCount || (count == maxCount && titleName.compareTo(maxTitle) < 0)) {
                maxTitle = titleName;
                maxCount = count;
            }
        }
        bw.write(maxTitle + "");
        bw.flush();
        bw.close();
    }
}
