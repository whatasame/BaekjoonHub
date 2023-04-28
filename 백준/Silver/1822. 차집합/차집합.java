import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /* 입력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] setA = new int[N];
        for (int i = 0; i < N; i++) {
            setA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] setB = new int[M];
        for (int i = 0; i < M; i++) {
            setB[i] = Integer.parseInt(st.nextToken());
        }

        /* 해결 */
        List<Integer> intersection = solution(setA, setB);

        /* 출력 */
        if (intersection.size() == 0) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(intersection.size())
                    .append('\n');
            for (int element : intersection) {
                sb.append(element).append(' ');
            }
            System.out.println(sb);
        }

        br.close();
    }

    private static List<Integer> solution(int[] setA, int[] setB) {
        List<Integer> intersection = new LinkedList<>();

        /* 이진 검색을 위한 정렬 */
        Arrays.sort(setB);

        /* B에 A의 요소가 있는지 확인*/
        for (int data : setA) {
            if (Arrays.binarySearch(setB, data) < 0) { // 없다면 교집합에 추가
                intersection.add(data);
            }
        }

        /* 후처리 - 크기순 정렬 */
        Collections.sort(intersection);

        return intersection;
    }
}