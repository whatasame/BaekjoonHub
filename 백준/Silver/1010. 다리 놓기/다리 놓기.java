import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        int T = Integer.parseInt(br.readLine());

        /* Run solution */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            sb.append(solution(N, M)).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static int solution(int N, int M) {
        /* compute combination mCn */
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= Math.min(i, N); j++) {
                if (j == 0 || j == i) { // mC0 = mCm = 1
                    dp[i][j] = 1;
                } else { // mCn = m-1Cn-1 + m-1Cn
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[M][N];
    }
}