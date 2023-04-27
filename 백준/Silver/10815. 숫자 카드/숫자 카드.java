import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 입력 */
        final int N = Integer.parseInt(br.readLine());
        HashSet<Integer> owns = new HashSet<>(); // 중복 없으므로 Set 이용
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            owns.add(Integer.parseInt(st.nextToken()));
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

    private static String solution(Set<Integer> owns, int[] targets) {
        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            int result = owns.contains(target) ? 1 : 0;
            sb.append(result).append(' ');
        }

        return sb.toString();
    }

}