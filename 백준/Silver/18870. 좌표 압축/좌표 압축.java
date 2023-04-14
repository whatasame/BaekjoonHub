import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 입력 데이터 읽기 */
        final int N = Integer.parseInt(br.readLine());

        /* 좌표 배열 생성 */
        int[] positions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        /* solution 실행 */
        List<Integer> result = solution(positions);

        /* 결과 출력 */
        StringBuilder sb = new StringBuilder();
        for (int count : result) {
            sb.append(count).append(' ');
        }
        System.out.println(sb);

        br.close();
    }

    private static List<Integer> solution(int[] positions) {
        /* 좌표 배열 정렬*/
        int[] sortedPositions = Arrays.copyOf(positions, positions.length);
        Arrays.sort(sortedPositions);

        /* 중복 제거 배열 생성 */
        List<Integer> distinctPositions = new ArrayList<>();
        for (int i = 0; i < sortedPositions.length; i++) {
            if (i == 0 || sortedPositions[i - 1] != sortedPositions[i]) {
                distinctPositions.add(sortedPositions[i]);
            }
        }

        /* 중복 제거 배열의 좌표에 대하여 정렬된 좌표 배열의 lowerBound 계산 */
        List<Integer> lowerBoundList = new ArrayList<>();
        for (int pos : positions) {
            lowerBoundList.add(Collections.binarySearch(distinctPositions, pos));
        }

        return lowerBoundList;
    }

}