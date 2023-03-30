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
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int repeat = Integer.parseInt(st.nextToken());
            final String target = st.nextToken();

            String result = solution(repeat, target);
            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static String solution(int repeat, String target) {
        StringBuilder result = new StringBuilder();

        char[] str = target.toCharArray();
        for (char c : str) { // Retrieve target
            for (int i = 0; i < repeat; i++) { // Repeat each character
                result.append(c);
            }
        }

        return result.toString();
    }


}