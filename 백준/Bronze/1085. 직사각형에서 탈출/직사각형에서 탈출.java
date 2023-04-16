import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /* Read input x, y, w, h */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        /* Compute distance */
        int distanceX = Math.min(x, w - x);
        int distanceY = Math.min(y, h - y);

        /* Print result */
        System.out.println(Math.min(distanceX, distanceY));

        br.close();
    }
}
