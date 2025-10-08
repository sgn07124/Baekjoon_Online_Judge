import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 친구의 이름을 모두 HashMap에 index와 매칭
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            indexMap.put(friends[i], i);
        }
        
        int [][] giftArray = new int [friends.length][friends.length];  // 1번 표
        int [] giftNum = new int [friends.length];  // 선물 지수
        for (String gift : gifts) {
            String [] giftSplit = gift.split(" ");
            int giftIndex = indexMap.get(giftSplit[0]);  // 선물을 준 사람의 인덱스
            int receiveIndex = indexMap.get(giftSplit[1]);  // 선물을 받은 사람의 인덱스
            giftNum[giftIndex]++;
            giftNum[receiveIndex]--;
            giftArray[giftIndex][receiveIndex]++;
        }
        
        int nowGift[] = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (giftArray[i][j] > giftArray[j][i]) nowGift[i]++;
                else if (giftArray[i][j] == giftArray[j][i] && giftNum[i] > giftNum[j])
                    nowGift[i]++;
            }
        }
        
        return Arrays.stream(nowGift).max().getAsInt();
    }
}