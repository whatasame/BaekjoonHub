import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Loop about K classes */
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; i++) {
            /* Run algorithm */
            String result = solution(i, br.readLine());

            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static String solution(int classNum, String data) {
        /* Init math grade list */
        StringTokenizer st = new StringTokenizer(data, " ");
        int studentCount = Integer.parseInt(st.nextToken());
        int[] gradeList = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            gradeList[i] = Integer.parseInt(st.nextToken());
        }

        /* Sort list */
        Arrays.sort(gradeList);

        /* Traverse list */
        int before = gradeList[gradeList.length - 1];
        int maxGrade = before;
        int minGrade = before;
        int largestGap = -1;
        for (int i = gradeList.length - 2; i >= 0; i--) {
            int now = gradeList[i];
            maxGrade = Math.max(maxGrade, now);
            minGrade = Math.min(minGrade, now);
            largestGap = Math.max(largestGap, before - now);
            before = now;
        }

        /* Generate result */
        StringBuilder result = new StringBuilder();
        result.append("Class ").append(classNum).append('\n');
        result.append("Max ").append(maxGrade).append(", ");
        result.append("Min ").append(minGrade).append(", ");
        result.append("Largest gap ").append(largestGap);

        return result.toString();
    }
}