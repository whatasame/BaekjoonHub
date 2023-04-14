import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /* Read input str */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] str = br.readLine().toCharArray();

        /* Cover string */
        int countX = 0;
        for (char c : str) {
            if (c == '.') {
                if (countX % 2 != 0) {
                    sb = new StringBuilder("-1");
                    break;
                } else {
                    cover(countX);
                }

                sb.append('.');
                countX = 0;
            } else if (c == 'X') {
                countX++;
            }
        }

        /* Cover last substring */
        if (countX % 2 != 0) {
            sb = new StringBuilder("-1");
        } else {
            cover(countX);
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    public static void cover(int countX) {
        while (countX != 0) {
            if (countX == 2) {
                sb.append("BB");
                countX -= 2;
            } else {
                sb.append("AAAA");
                countX -= 4;
            }
        }
    }

}
