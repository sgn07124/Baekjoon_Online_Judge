import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int [][] sudoku;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line.charAt(j) - '0';
                if (sudoku[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sudoku[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    // 재귀적으로 스도쿠를 완성해가는 함수
    private static boolean dfs(int depth) {
        // 모든 빈칸을 채웠으면 true 반환 (스도쿠 완성)
        if (depth == list.size()) return true;

        // 현재 처리해야 할 빈칸의 좌표 가져오기
        int y = list.get(depth)[0];
        int x = list.get(depth)[1];

        // 빈칸에 1부터 9까지 가능한 숫자 시도
        for (int i = 1; i < 10; i++) {
            // 현재 빈칸에 숫자 i를 넣어봄
            sudoku[y][x] = i;

            // 숫자 i가 유효하고 다음 재귀 호출 결과가 true라면 스도쿠 완성
            if (isValid(y, x) && dfs(depth + 1)) return true;
        }

        // 모든 숫자를 시도해도 스도쿠를 완성할 수 없으면 빈칸 초기화
        sudoku[y][x] = 0;

        // 현재 단계에서 스도쿠를 완성할 수 없으므로 false 반환
        return false;
    }

    // 스도쿠 규칙을 검사하는 함수 (가로, 세로, 3x3 영역 검사)
    private static boolean isValid(int i, int j) {
        // 같은 열에 같은 숫자가 있는지 검사
        for (int k = 0; k < 9; k++) {
            if (i != k && sudoku[k][j] == sudoku[i][j]) return false; // 세로 검사
            if (j != k && sudoku[i][k] == sudoku[i][j]) return false; // 가로 검사
        }

        // 3x3 영역의 시작 위치 계산
        for (int ni = (i / 3) * 3, k = 0; k < 3; k++, ni++) {
            for (int nj = (j / 3) * 3, l = 0; l < 3; l++, nj++) {
                // 3x3 영역 내에 같은 숫자가 있는지 검사
                if (ni != i && nj != j && sudoku[ni][nj] == sudoku[i][j]) return false;
            }
        }

        // 가로, 세로, 3x3 영역 모두 유효하다면 true 반환
        return true;
    }
}