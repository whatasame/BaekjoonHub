import java.util.*;
import java.io.*;

/* 추가 테스트 케이스
6
10
10
20
20
20
30
result:
18
20
20
20
*/

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
        Map<Integer, Integer> freq = new HashMap<>();
        for (int datum : data) {
            freq.put(datum, freq.getOrDefault(datum, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = freq.entrySet();
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e1.getKey() - e2.getKey();
            }
            return e2.getValue() - e1.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            heap.offer(entry);
        }
        Map.Entry<Integer, Integer> first = heap.poll();
        result[2] = first.getKey();
        if (!heap.isEmpty()) {
            Map.Entry<Integer, Integer> second = heap.poll();
            if (first.getValue().equals(second.getValue())) {
                result[2] = second.getKey();
            }
        }

        // 범위 구하기
        result[3] = data[N - 1] - data[0];

        return result;
    }

}