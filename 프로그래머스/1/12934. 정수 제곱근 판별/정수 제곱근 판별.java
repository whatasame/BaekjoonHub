import java.util.*;

class Solution {
    public long solution(long n) {
        double result = Math.sqrt(n);
        if (result % 1 == 0) {
            long answer = (long) result + 1;
            return (long) answer * answer;
        }
        
        return -1;
    }
}