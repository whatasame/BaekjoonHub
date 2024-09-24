// 무손실 알고리즘
// 입력은 모두 대문자

import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        String[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for (int idx = 0; idx < capitals.length; idx++) {
            dict.put(capitals[idx], idx + 1);
        }

        int nxt = capitals.length + 1; // 27
        String[] split = msg.split("");
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String sub = null;
            for (int j = i; j < split.length; j++) {
                sub = Arrays.stream(split, i, j + 1)
                        .collect(Collectors.joining(""));
                if (!dict.containsKey(sub)) {
                    dict.put(sub, nxt++);
                    String prev = sub.substring(0, sub.length() - 1);
                    answer.add(dict.get(prev));

                    i += prev.length() - 1;
                    sub = null;
                    break;
                }
            }
            if (sub != null) {
                answer.add(dict.get(sub));
                i += sub.length() - 1;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}