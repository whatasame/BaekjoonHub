import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input data */
        final int N = Integer.parseInt(br.readLine());
        final String sequence = br.readLine();
        final int X = Integer.parseInt(br.readLine());

        /* Init range number array */
        boolean[] isExist = new boolean[2000001]; // 1 to 2,000,000

        /* Count number pair */
        int pairCount = 0;
        StringTokenizer st = new StringTokenizer(sequence);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            /* Find pair number */
            int pair = X - num;
            if (pair > 0 && isExist[pair]) { // Check pair exist
                pairCount++;
            }

            /* Mark num */
            isExist[num] = true;
        }

        /* Print result */
        System.out.println(pairCount);

        br.close();
    }
}