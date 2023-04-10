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

        /* Init count arr */
        int[] counts = new int[26];

        /* Count character */
        for (char c : charArr) {
            counts[c - 'A']++;
        }

        /* Get max char */
        int maxCount = 0;
        for (int count : counts) {
            maxCount = Math.max(count, maxCount);
        }

        /* Get max char list */
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == maxCount) {
                charList.add((char) (i + 'A'));
            }
        }

        /* Return char */
        if (charList.size() == 1) {
            return charList.get(0);
        } else {
            return '?';
        }
    }
}