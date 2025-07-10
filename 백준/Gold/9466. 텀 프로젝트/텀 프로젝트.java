import java.io.*;
import java.util.*;

public class Main {
    /*
    1. 혼자 팀을 하고 싶어하는 사람을 선택한 사람은 팀을 이룰 수 없다.
    2. 팀을 이루기 위해서는 서로를 선택해야만 한다.
     */

    static boolean [] visit, done;  // 방문 여부, 팀 완료 여부
    static int [] member;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            member = new int[n + 1];
            visit = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                member[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }
            System.out.println(n - count);
        }
    }

    static void dfs(int n) {
        // 이미 방문한 경우
        if (visit[n]) {
            done[n] = true;  // 팀 편성 완료
            count++;  // 팀 편성 완료된 인원 추가
        } else {
            visit[n] = true;
        }

        // 다음 학생이 아직 팀 결성을 못한 경우
        if (!done[member[n]]) {
            dfs(member[n]);
        }

        visit[n] = false;
        done[n] = true;
    }
}