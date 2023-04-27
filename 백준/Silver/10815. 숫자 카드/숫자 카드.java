import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 입력 */
        final int N = Integer.parseInt(br.readLine());
        int[] owns = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            owns[i] = Integer.parseInt(st.nextToken());
        }
        final int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        /* 출력 */
        System.out.println(solution(owns, targets));

        br.close();
    }

    private static String solution(int[] owns, int[] targets) {
        Arrays.sort(owns);

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            int result = Arrays.binarySearch(owns, target) >= 0 ? 1 : 0;
            sb.append(result).append(' ');
        }

        return sb.toString();
    }

}