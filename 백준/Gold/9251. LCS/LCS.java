import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        char a [] = br.readLine().toCharArray();
        char b [] = br.readLine().toCharArray();

        int a1 = a.length;
        int a2 = b.length;
        
        int dp [][] = new int [a1+1][a2+1];
        
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        bw.write(dp[a1][a2] + "");
        bw.flush();
        bw.close();
    }
}