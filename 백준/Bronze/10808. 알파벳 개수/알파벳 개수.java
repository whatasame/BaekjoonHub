import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input string */
        char[] str = br.readLine().toCharArray();

        /* Init alphabet count array */
        int[] count = new int[26]; // 'a' to 'z': 26

        /* Count alphabet */
        for (char c : str) {
            count[c - 'a']++;
        }

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (int n : count) {
            sb.append(n).append(' ');
        }
        System.out.println(sb);

    }
}