import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /* Read input data */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* Init basket */
        int[] basket = new int[N + 1]; // 1 to N, 0 is not used
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        /* Change basket */
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            final int i = Integer.parseInt(st.nextToken());
            final int j = Integer.parseInt(st.nextToken());
            solution(basket, i, j);
        }

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(basket[i]).append(' ');
        }
        System.out.println(sb);

        br.close();
    }

    private static void solution(int[] basket, int i, int j) {
        int tmp = basket[i];
        basket[i] = basket[j];
        basket[j] = tmp;
    }
}