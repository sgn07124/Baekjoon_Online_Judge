
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        TreeSet<Problem> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.level == o2.level) {
                // 문제의 난이도가 같다면 문제 번호가 작은 것 순서대로 정렬
                return o1.number - o2.number;
            }
            // 문제 난이도 오름차순
            return o1.level - o2.level;
        });

        Map<Integer, Integer> map = new HashMap<>();  // 문제번호 - 난이도 쌍

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(n, l);
            treeSet.add(problem);
            map.put(n, l);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add" :
                    int n = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    Problem problem = new Problem(n, l);
                    treeSet.add(problem);
                    map.put(n, l);
                    break;

                case "recommend" :
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        // 가장 어려운 문제의 번호를 출력 => 최대힙
                        bw.write(treeSet.last().number + "\n");
                    } else if (num == -1) { // 가장 쉬운 문제의 번호를 출력 => 최소힙
                        bw.write(treeSet.first().number + "\n");
                    }
                    break;

                case "solved":
                    int s_n = Integer.parseInt(st.nextToken());
                    int s_l = map.get(s_n);
                    treeSet.remove(new Problem(s_n, s_l));
                    break;

                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    static class Problem {
        int number;  // 문제 번호
        int level;  // 난이도

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }
    }
}