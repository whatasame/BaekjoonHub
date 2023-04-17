import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(numbers));

        br.close();
    }

    private static int solution(int[] nums) {
        /* 두 수의 합 리스트를 생성 */
        List<Integer> twos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                twos.add(nums[i] + nums[j]);
            }
        }

        /* 이분 탐색을 위한 정렬 */
        Arrays.sort(nums);
        Collections.sort(twos);

        /* 원본 배열에서 가장 큰 d = nums[i] 찾기 */
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                /* twos[?] + nums[j] = nums[i]를 만족하는 값 있는지 확인 */
                if (Collections.binarySearch(twos, nums[i] - nums[j]) >= 0) { 
                    return nums[i]; // 최대 d
                }
            }
        }

        return -1;
    }

}