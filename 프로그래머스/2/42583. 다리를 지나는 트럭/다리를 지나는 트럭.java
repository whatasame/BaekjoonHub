// 정해진 순서 고정
// 최대 트럭 개수 = 다리 길이
// 완전히 지나갈 때 = 다리를 통과할 때 1초 소요

// 2, 15, [7, 2, 15, 3]
// 2, 15, [15, 14, 13, 2, 1]

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int length, int weight, int[] weights) {
        int remain = weight;
        int last = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < length; i++) queue.add(-1); // EMPTY;
        
        int answer = 0;
        int count = 0;
        while (count != weights.length) { // 모든 트럭이 통과할 때까지
            answer += 1; // 1초 경과
            
            // 트럭 통과
            int idx = queue.remove();
            if (idx != -1) {
                remain += weights[idx];
                count += 1;
            } 
            
            if (last >= weights.length) continue; // 모든 트럭 진입 완료
            
            // 트럭 추가
            if (weights[last] <= remain) {
                queue.add(last);
                remain -= weights[last];
                last += 1;
            } else {
                queue.add(-1);
            }
        }
        
        return answer;
    }
}