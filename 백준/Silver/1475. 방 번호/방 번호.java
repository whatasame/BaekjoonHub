import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input number string */
        final char[] numStr = br.readLine().toCharArray();

        /* Init decimal number count array */
        int[] count = new int[10];

        /* Check number string */
        for (char c : numStr) {
            count[c - '0']++;
        }

        /* Compute set count */
        int setCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            setCount = Math.max(setCount, count[i]);
        }
        int count6and9 = count[6] + count[9];
        count6and9 = count6and9 % 2 == 0 ? count6and9 / 2 : count6and9 / 2 + 1;

        setCount = Math.max(setCount, count6and9);

        /* Print result */
        System.out.println(setCount);

        br.close();
    }


}