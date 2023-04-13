import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringBuilder sb = new StringBuilder();
        String sentence = br.readLine();
        while (!sentence.equals("#")) {
            /* Run solution */
            sb.append(solution(sentence)).append('\n');
            sentence = br.readLine();
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static long solution(String sentence) {
        return sentence.toLowerCase().chars()
                .filter(c -> c == 'a'
                        || c == 'e'
                        || c == 'i'
                        || c == 'o'
                        || c == 'u')
                .count();
    }

}