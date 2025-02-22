import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int [][] arr = new int[height][height];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = triangle[i][j];
            }
        }
        
        // 양 끝 dp 과정. 가장 자리의 부분의 합은 변하지 않음
        for (int i = 1; i < height; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i][0];  // 왼쪽 가장자리
            arr[i][i] = arr[i - 1][i - 1] + arr[i][i];  // 오른쪽 가장자리
        }
        
        // 중간 경로 dp 과정
        for (int i = 2; i < height; i++) {
            for (int j = 1; j < i; j++) {
                // 왼쪽 위의 값과 바로 위의 값 중 큰 값에 현재 위치를 더하여 계산
                arr[i][j] = Math.max(arr[i - 1][j - 1] , arr[i - 1][j]) +  + arr[i][j];
            }
        }
        
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[height - 1][i] > max) max = arr[height - 1][i];
        }
        
        return max;
    }
}