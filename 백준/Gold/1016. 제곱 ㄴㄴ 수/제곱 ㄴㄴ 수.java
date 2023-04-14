import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringTokenizer st = new StringTokenizer(br.readLine());
        final long MIN = Long.parseLong(st.nextToken());
        final long MAX = Long.parseLong(st.nextToken());

        /* Run solution */
        int result = solution(MIN, MAX);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static int solution(long MIN, long MAX) {
        boolean[] isDivided = new boolean[(int) (MAX - MIN + 1)]; // 제곱ㅇㅇ수 배열 (idx: k-min)

        for (long i = 2; i * i <= MAX; i++) {
            /* 가장 작은 제곱ㅇㅇ수 start 구하기 */
            long squareNum = i * i; // 제곱수
            long quotient = MIN % squareNum == 0 ? MIN / squareNum : MIN / squareNum + 1;
            long start = squareNum * quotient;


            /* start ~ MAX(offset: 제곱수)를 제곱ㅇㅇ수로 표시 */
            for (long k = start; k <= MAX; k += squareNum) {
                isDivided[(int) (k - MIN)] = true;
            }
        }

        /* 제곱ㄴㄴ수 개수 세기 */
        int count = 0;
        for (boolean be : isDivided) {
            if (!be) {
                count++;
            }
        }

        return count;
    }

}
