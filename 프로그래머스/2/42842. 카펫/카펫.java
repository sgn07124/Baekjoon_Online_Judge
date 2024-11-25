class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        int area = brown + yellow;
        for (int row = area; row > 1; row--) {
            if (area % row == 0) {  // 카펫의 가로 세로의 길이를 구한다. 
                int col = area / row;  // 세로
                if ((row - 2) * (col - 2) == yellow) {  // 가로, 세로에서 각각 2를 뺀 값을 서로 곱한 값이 노란색 개수가 되야함.
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                }
            }
        }
        return answer;
    }
}