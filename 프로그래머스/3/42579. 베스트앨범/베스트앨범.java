import java.util.*;

class Solution {
    static class Album implements Comparable<Album> {
        int idx, cnt;
        
        public Album(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        
        public int compareTo(Album album) {
            if (this.cnt == album.cnt) {
                return this.idx - album.idx;
            } else {
                return album.cnt - this.cnt;
            }
        }
    }
        
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        Map<String, Integer> genreRank = new HashMap<>();  // <장르, 총 play 횟수>
        Map<String, List<Album>> albumRank = new HashMap<>();  // <장르, Album 리스트>
        
        for (int i = 0; i < len; i++) {
            genreRank.put(genres[i], genreRank.getOrDefault(genres[i], 0) + plays[i]);
            albumRank.putIfAbsent(genres[i], new ArrayList<>());  // putIfAbsent(): map에 key가 존재하지 않으면 추가
            albumRank.get(genres[i]).add(new Album(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genreRank.keySet());
        sortedGenres.sort((a, b) -> genreRank.get(b) - genreRank.get(a));
        
        List<Integer> ans = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Album> genreAlbum = albumRank.get(genre);
            Collections.sort(genreAlbum);
            for (int i = 0; i < Math.min(2, genreAlbum.size()); i++) {
                ans.add(genreAlbum.get(i).idx);
            }
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}