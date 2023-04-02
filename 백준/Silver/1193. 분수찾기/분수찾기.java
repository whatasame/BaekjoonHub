import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        final int N = Integer.parseInt(br.readLine());

        /* Run solution */
        String result = solution(N);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static String solution(int N) {
        /* Move to the level which exist Nth fraction */
        int num = 0, level = 1;
        while (num + level < N) {
            num += level++;
        }

        /* Move to the Nth fraction */
        int count = N - num;

        /* Generate Nth fraction */
        if (level % 2 == 0) {
            return String.format("%d/%d", count, level + 1 - count);
        } else {
            return String.format("%d/%d", level + 1 - count, count);
        }

    }

}