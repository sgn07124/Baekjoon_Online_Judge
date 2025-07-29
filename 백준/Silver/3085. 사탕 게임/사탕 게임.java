import java.util.*;
import java.io.*;

class Main {
    static char [][] board;
    static int n, max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; i++) {
		    String line = br.readLine();
		    for (int j = 0; j < n; j++) {
		        board[i][j] = line.charAt(j);
		    }
		}
		
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        // 가로 교환
		        if (j + 1 < n) {
		            swap(i, j, i, j + 1);
		            checkMaxLength();
		            swap(i, j, i, j + 1);  // 원래대로
		        }
		        
		        // 세로 교환
		        if (i + 1 < n) {
		            swap(i, j, i + 1, j);
		            checkMaxLength();
		            swap(i, j, i + 1, j);
		        }
		    }
		}
		
		System.out.println(max);
	}
	
    // 먹을 수 있는 최대 사탕 개수 계산
	static void checkMaxLength() {
	    // 가로
	    for (int i = 0; i < n; i++) {
	        int cnt = 1;
	        for (int j = 1; j < n; j++) {
	            if (board[i][j] == board[i][j - 1]) cnt++;
	            else cnt = 1;
	            max = Math.max(max, cnt);
	        }
	    }
	    
	    // 세로
	    for (int j = 0; j < n; j++) {
	        int cnt = 1;
	        for (int i = 1; i < n; i++) {
	            if (board[i][j] == board[i - 1][j]) cnt++;
	            else cnt = 1;
	            max = Math.max(max, cnt);
	        }
	    }
	}
	
	static void swap(int x1, int y1, int x2, int y2) {
	    char temp = board[x1][y1];
	    board[x1][y1] = board[x2][y2];
	    board[x2][y2] = temp;
	}
}