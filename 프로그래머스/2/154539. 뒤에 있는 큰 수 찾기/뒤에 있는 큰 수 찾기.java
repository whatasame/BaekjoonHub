// 뒷 큰수가 없으면 -1

// [5, 4, 3, 2, 1] -> [-1, -1, -1, -1, -1]
// [1, 5, 2, 3, 6] -> [5, 6, 3, 6, -1]

// nested for -> n(n+1)/2 = n^2 [1, 1, 1, ..., 2]
// 일반적인 투포인터 -> right가 다시 왼쪽으로 와야 함
// tos보다 현재 숫자가 더 큰 경우 뒷 큰수이므로 pop 

import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int now = numbers[i];
            while (!stack.isEmpty() && numbers[stack.peek()] < now) {
                answer[stack.pop()] = now;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}