import java.util.*;

class Solution {
    
    public String solution(String str) {
        Set<Character> charSet = new HashSet();
        
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                continue;
            }
            
            charSet.add(c);
            sb.append(c);
        }
        
        return sb.toString();
    }
}