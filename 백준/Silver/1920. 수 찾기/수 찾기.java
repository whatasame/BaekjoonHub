import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Init array 1 */
        final int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        /* Init array 2 */
        final int M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        /* Find number */
        Arrays.sort(nArr);
        StringBuilder sb = new StringBuilder();
        for (int target : mArr) {
            int index = Arrays.binarySearch(nArr, target); // find target in nArr

            int result = index >= 0 ? 1 : 0; // true: index == target index, false: index == insertion point + 1

            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

}