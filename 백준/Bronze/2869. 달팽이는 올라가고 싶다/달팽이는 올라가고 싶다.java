import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());

        /* Run solution */
        int result = solution(A, B, V);

        /* Print result */
        System.out.println(result);

        br.close();

    }

    private static int solution(int A, int B, int V) {
        int oneDayMoveAmount = A - B;
        double day = (double) (V - A) / oneDayMoveAmount;

        return (int) Math.ceil(day + 1);
    }

}