import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> appear = new HashSet<>();
        
        int num = 1, level = 1;
        char lastChar = words[0].charAt(0);
        for(String word : words){
            /* 탈락 조건 */
            if (appear.contains(word)
               || word.charAt(0) != lastChar){
                return new int[]{num, level};
            }            

            /* 끝말잇기 진행 */
            appear.add(word);
            lastChar = word.charAt(word.length() - 1);
            
            /* 순서 업데이트 */
            if (++num > n){
                num = 1;
                level++;
            }
        }
            
        return new int[]{0, 0};
    }
}