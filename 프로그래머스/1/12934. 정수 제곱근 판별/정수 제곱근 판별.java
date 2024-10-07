import java.util.*;

class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);

        if (sqrt * sqrt != n) return -1;

        return (sqrt + 1) * (sqrt + 1);
    }
}
