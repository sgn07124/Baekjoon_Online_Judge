class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        int len = sizes.length;
        
        for (int i = 0; i < len; i++) {
            // 가로, 세로 중 큰 값을 sizes[i][0]에 저장
            if (sizes[i][0] < sizes[i][1]) {  // 가로 < 세로
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            
            // width에 가로의 값(width[i][0]) 중 최댓값을 저장
            if (sizes[i][0] > width) {
                width = sizes[i][0];
            }
            
            // height에 세로의 값(width[i][1]) 중 최댓값을 저장
            if (sizes[i][1] > height) {
                height = sizes[i][1];
            }
        }
        return width * height;
    }
}