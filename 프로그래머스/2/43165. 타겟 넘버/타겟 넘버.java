// 순서를 바꾸지 않음
// 2^n = 2^20 = 1,048,576

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        return dfs(numbers, target, index + 1, sum + numbers[index]) 
             + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
