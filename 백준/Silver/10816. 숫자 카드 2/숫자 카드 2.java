import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Init nArr */
        final int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        /* Init mArr */
        final int M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        /* Run algorithm */
        String result = solution(nArr, mArr);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static String solution(int[] nArr, int[] mArr) {
        Arrays.sort(nArr);

        /* Compute count */
        StringBuilder sb = new StringBuilder();
        for (int target : mArr) {
            int lowerBound = lowerBound(nArr, target);
            int upperBound = upperBound(nArr, target);

            int count = upperBound - lowerBound;
            sb.append(count).append(' ');
        }

        return sb.toString();
    }


    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}