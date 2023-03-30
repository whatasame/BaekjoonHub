import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        int T = Integer.parseInt(br.readLine());

        /* Run algorithm */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String keyLog = br.readLine();

            String password = solution(keyLog);
            sb.append(password).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static String solution(String log) {
        /* Init doubly linked list */
        List<Character> list = new LinkedList<>();

        /* Move cursor end of log */
        ListIterator<Character> itr = list.listIterator();

        /* Compute operator */
        for (char c : log.toCharArray()) {
            switch (c) {
                case '<':
                    if (itr.hasPrevious()) {
                        itr.previous();
                    }
                    break;
                case '>':
                    if (itr.hasNext()) {
                        itr.next();
                    }
                    break;
                case '-':
                    if (itr.hasPrevious()) {
                        itr.previous();
                        itr.remove();
                    }
                    break;
                default:
                    itr.add(c);
                    break;
            }

        }

        /* Generate password */
        StringBuilder password = new StringBuilder();
        for (char c : list) {
            password.append(c);
        }

        return password.toString();
    }

}