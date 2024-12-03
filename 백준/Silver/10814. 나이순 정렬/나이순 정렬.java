import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Member {
        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Member [] member = new Member[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            member[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(member, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age == o2.age) {
                    return o1.idx - o2.idx;
                }
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(member[i].age + " " + member[i].name + "\n");
        }
        bw.flush();
        bw.close();
    }
}