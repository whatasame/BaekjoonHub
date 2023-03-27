import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input A, B, C */
        final int A = Integer.parseInt(br.readLine());
        final int B = Integer.parseInt(br.readLine());
        final int C = Integer.parseInt(br.readLine());

        /* Compute sum and count number */
        int sum = A * B * C; // less than 1,000,000,000 -> int OK
        char[] sumStr = String.valueOf(sum).toCharArray();
        int[] count = new int[10];
        for (char c : sumStr) {
            count[c - '0']++;
        }

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (int n : count) {
            sb.append(n).append('\n');
        }
        System.out.println(sb);

        br.close();
    }


}