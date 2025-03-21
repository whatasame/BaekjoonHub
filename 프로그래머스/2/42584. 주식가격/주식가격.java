// 모든 가격에 대하여 떨어지지 않은 시간을 반환

// 매 초마다 갱신 = O(n^2)
// stack = 현재 시점보다 높으면 계속 pop

// [1, 2, 3, 4, 5] -> [4, 3, 2, 1, 0]
// [5, 4, 3, 2, 1] -> [0, 0, 0, 0, 0]

import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - 1 - i; // 최대 시간
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];
            
            while (!stack.isEmpty() && prices[stack.peek()] > now) {
                answer[stack.pop()] -= prices.length - 1 - i;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}