import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        String word = br.readLine();

        /* Run solution */
        char result = solution(word);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static char solution(String word) {
        char[] charArr = word.toUpperCase().toCharArray();

        /* Init map */
        Map<Character, Integer> countMap = new HashMap<>();

        /* Count character */
        for (char c : charArr) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        /* Find maxCount */
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }

        /* Find maxCount character */
        List<Character> charList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                charList.add(entry.getKey());
            }
        }

        /* Return character */
        if (charList.size() == 1) {
            return charList.get(0);
        } else {
            return '?';
        }
    }
}