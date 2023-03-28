import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /* Read input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] initStr = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        final List<String> instructions = new LinkedList<>();
        while (N-- > 0) {
            instructions.add(br.readLine());
        }
        br.close();

        /* Run algorithm */
        List<Character> result = solution(initStr, instructions);

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    private static List<Character> solution(char[] str, List<String> instructions) {
        /* Init content */
        List<Character> content = new LinkedList<>(); // Set init string
        for (char c : str) {
            content.add(c);
        }
        ListIterator<Character> cursor = content.listIterator(); // Move cursor to end
        while (cursor.hasNext()) {
            cursor.next();
        }

        /* Compute operator */
        for (String instruction : instructions) {
            char operator = instruction.charAt(0);

            switch (operator) {
                case 'L':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case 'D':
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    cursor.add(instruction.charAt(2));
                    break;
            }
        }

        return content;
    }

}