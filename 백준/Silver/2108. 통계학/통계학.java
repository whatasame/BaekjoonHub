import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /* 입력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        /* 해결 */
        int[] result = solution(N, data);

        /* 출력 */
        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);

    }

    private static int[] solution(int N, int[] data) {
        int[] result = new int[4];

        // 산술 평균 구하기
        int sum = 0;
        for (int datum : data) {
            sum += datum;
        }
        result[0] = (int) Math.round(sum / (double) N);

        // 중앙값 구하기
        Arrays.sort(data);
        result[1] = data[N / 2];

        // 최빈값 구하기
        int[] freq = new int[8002]; // -4000 to 4000
        int maxFreq = 0;
        for (int datum : data) {
            int idx = datum + 4000;
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
        }
        boolean hasSameFreq = false;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                result[2] = i - 4000;
                if (hasSameFreq) {
                    break;
                }
                hasSameFreq = true;
            }
        }


        // 범위 구하기
        result[3] = data[N - 1] - data[0];

        return result;
    }

}