// 변환할 수 없는 경우 0 (words에 target이 없거나 중간 단계가 없는 경우)
// 중간단계가 없는경우: "hit", "dog", ["hot", "cot", "dog"] -> 0
// 완전 다른 단어로 변경해야하는 경우는 없다: "hit", "dog", ["ait", "abt", "abc", "abg", "aog", "dog"] -> 6이 아닌 5 (abt -> abg)
// "hit", "dog", ["ait", "bit", "big", "bog", "dog"] -> 4

// 모든 단어를 순회 = w!

import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        int w = words.length;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(begin, new boolean[w]));
        
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            
            if (current.now.equals(target)) {
                int tmp = 0;
                for (int i = 0; i < current.visited.length; i++) {
                    if (current.visited[i]) tmp += 1;
                }
                answer = Math.min(answer, tmp);
            }
            
            for (int i = 0; i < w; i++) { // O(w)
                if (current.visited[i]) continue;
                if (diff(current.now, words[i]) != 1) continue;
                
                boolean[] new_visited = Arrays.copyOf(current.visited, current.visited.length);
                new_visited[i] = true;
                
                queue.offer(new Pair(words[i], new_visited));
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    long diff(String s1, String s2) { // O(l * w) = 500
        return IntStream.range(0, s1.length())
            .filter(i -> s1.charAt(i) != s2.charAt(i))
            .count();
    }
    
    static class Pair {
        String now;
        boolean[] visited;
        
        Pair(String now, boolean[] visited) {
            this.now = now;
            this.visited = visited;
        }
    }
}