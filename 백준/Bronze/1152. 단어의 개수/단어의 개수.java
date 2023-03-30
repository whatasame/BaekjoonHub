import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        final String inputStr = br.readLine();

        /* Run algorithm */
        int result = solution(inputStr);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static int solution(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");

        int result = 0;
        while (st.hasMoreTokens()) { // Check word
            st.nextToken();
            result++;
        }

        return result;
    }


}