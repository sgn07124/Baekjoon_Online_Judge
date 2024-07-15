import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hashNum = new HashMap<>();  // <번호, 포켓몬 이름>로 저장하는 HashMap
        HashMap<String, Integer> hashName = new HashMap<>();  // <포켓몬 이름, 번호>로 저장하는 HashMap

        for (int i = 1; i <= N; i++) {  // HashMap에 포켓몬 입력
            String name = br.readLine();
            hashNum.put(i, name);
            hashName.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {  // 문제 입력
            String question = br.readLine();
            // 입력받은 문제가 번호인지, 포켓몬인지 판별
            if ( 49 <= question.charAt(0) && question.charAt(0) <= 57) {  // 번호이면?
                sb.append(hashNum.get(Integer.parseInt(question))).append("\n");
            } else {
                sb.append(hashName.get(question)).append("\n");
            }
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}