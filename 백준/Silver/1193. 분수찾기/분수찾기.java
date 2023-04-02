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
        while (num < N) { // Move (target level + 1)
            num += level++;
        }
        num -= (level - 1); // Back to target level

        /* Move to the Nth fraction */
        int count = 0;
        while (num != N) {
            num++;
            count++;
        }

        /* Generate Nth fraction */
        if (level % 2 == 0) {
            return String.format("%d/%d", level - count, count);
        } else {
            return String.format("%d/%d", count, level - count);
        }

    }

}