import java.util.*;
import java.io.*;

public class Main {

    public static int run(int n, int m, int[] nums){
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;
        int end = 0;
        for (int start = 0; start < n; start++) {
            while (end < n && nums[end] - nums[start] < m) {
                end++;
            }

            if (end == n) {
                break;
            }

            answer = Math.min(answer, nums[end] - nums[start]);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int result = run(n, m, nums);

        System.out.println(result);
    }
}
