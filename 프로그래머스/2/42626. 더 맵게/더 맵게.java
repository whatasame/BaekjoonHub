// min heap

// 만들 수 없는 경우 -1

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < scovilles.length; i++) {
            minHeap.add(scovilles[i]);
        }
        
        int answer = 0;
        while (minHeap.size() >= 2 && minHeap.peek() < K) {
            int first = minHeap.remove();
            int second = minHeap.remove();
            
            int sum = first + second * 2;
            minHeap.add(sum);
            answer += 1;
        }
        
        if (minHeap.peek() < K) return -1;
        
        return answer;
    }
}