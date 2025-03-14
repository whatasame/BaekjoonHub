// 변환할 수 없는 경우 0 (words에 target이 없거나 중간 단계가 없는 경우)
// 중간단계가 없는경우: "hit", "dog", ["hot", "cot", "dog"] -> 0
// 완전 다른 단어로 변경해야하는 경우는 없다: "hit", "dog", ["ait", "abt", "abc", "abg", "aog", "dog"] -> 6이 아닌 5 (abt -> abg)
// "hit", "dog", ["ait", "bit", "big", "bog", "dog"] -> 4

// 모든 단어를 순회 = w!

import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair(begin, 0));
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.steps;
            }
            
            for (String word: words) { // O(w)
                if (visited.contains(word)) continue;
                if (diff(current.word, word) != 1) continue;
                
                queue.offer(new Pair(word, current.steps + 1));
                visited.add(word);
            }
        }
        
        return 0;
    }
    
    long diff(String s1, String s2) { // O(l * w) = 500
        return IntStream.range(0, s1.length())
            .filter(i -> s1.charAt(i) != s2.charAt(i))
            .count();
    }
    
    static class Pair {
        String word;
        int steps;
        
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}