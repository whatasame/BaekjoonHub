import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int HOUR = Integer.parseInt(st.nextToken());
        final int MIN = Integer.parseInt(st.nextToken());

        /* Run solution */
        int[] result = solution(HOUR, MIN);

        /* Print result */
        System.out.println(result[0] + " " + result[1]);

        br.close();
    }


    private static int[] solution(int hour, int min) {
        min = hour * 60 + min; // Convert only minutes
        min -= 45; // Decrease 45 mins

        if (min < 0) { // Circular time
            min = 24 * 60 + min;
        }

        /* Generate result time */
        hour = min / 60;
        min = min % 60;

        return new int[]{hour, min};
    }
}