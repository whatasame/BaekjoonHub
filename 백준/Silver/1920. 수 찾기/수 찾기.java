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
            int result = binarySearch(nArr, target); // find target in nArr
            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static int binarySearch(int[] arr, int target) {
        /* NOTE: arr must be sorted */
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return 1;
            }
        }

        return 0; // target not found!
    }

}