import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static int [][] map;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Queue<int[]> person;
    static Queue<int[]> fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());  // 너비
            h = Integer.parseInt(st.nextToken());  // 높이
            
            map = new int[h][w];
            person = new LinkedList<>();
            fire = new LinkedList<>();
            
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (line.charAt(j) == '@') {  // 상근이의 위치
                        person.offer(new int[] {j, i, 0});
                    } else if (line.charAt(j) == '*') {  // 불의 위치
                        fire.offer(new int[] {j, i});
                    }
                }
            }
            
            int result = -1;
            
            out : while (true) {
                // 불 번짐
                int fire_size = fire.size();
                for (int i = 0; i < fire_size; i++) {
                    int [] pos = fire.poll();
                    fireMarking(pos[0], pos[1]);
                }
                
                // 상근 이동
                int person_size = person.size();
                for (int i = 0; i < person_size; i++) {
                    int [] pos = person.poll();
                    result = escape(pos[0], pos[1], pos[2]);
                    if (result != -1) break out;
                }
                if (person.isEmpty()) break;  // 상근이 탈출한 경우
            }
            if (result != -1) sb.append(result).append('\n');
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }
    
    static void fireMarking(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                if (map[ny][nx] == '.' || map[ny][nx] == '@') {
                    map[ny][nx] = '*';
                    fire.offer(new int[] {nx, ny});
                }
            }
        }
    }
    
    static int escape(int x, int y, int time) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                return time + 1;
            }
            
            if (map[ny][nx] == '.') {
                map[ny][nx] = '@';
                person.offer(new int[] {nx, ny, time + 1});
            }
        }
        return -1;
    }
}