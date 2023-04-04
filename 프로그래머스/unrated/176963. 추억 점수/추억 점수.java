import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        /* Generate yearningMap */
        Map<String, Integer> yearningMap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            yearningMap.put(name[i], yearning[i]);
        }

        /* Compute sum of yearning of photo */
        for(int i = 0; i < answer.length; i++){
            for(String person : photo[i]){
                answer[i] += yearningMap.getOrDefault(person, 0);
            }
        }

        return answer;
    }
}