// 순서를 바꾸지 않음
// 2^n = 2^20 = 1,048,576

import java.util.*;

class Solution {
    
    static int answer = 0;
    static int target;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        
        dfs(numbers, 0, 0);

        return answer;
    }
    
    void dfs(int[] numbers, int i, int tmp) {
        if (i == numbers.length) {
            if (tmp == target) {
                answer += 1;
            }
            
            return;
        }
        
        dfs(numbers, i + 1, tmp + numbers[i] * 1);
        dfs(numbers, i + 1, tmp + numbers[i] * -1);
    }
}