class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [] check = new boolean[n];
        
        // 시작 정점을 기준으로 dfs 진행하면서 인접한 정점들의 check[]를 true로 설정
        // true인 경우는 answer에 카운트가 되었으므로 넘어가고, false를 만나면 새로운 네트워크의 시작점이므로 dfs 진행.
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, int index, boolean[] check) {
        check[index] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (index != i && computers[index][i] == 1 && !check[i]) {
                dfs(computers, i, check);
            }
        }
    }
}