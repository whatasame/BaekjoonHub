import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Init room */
        final int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }

        /* Run algorithm */
        String result = solution(room);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static String solution(char[][] room) {
        /* Count about row */
        int rowCount = 0;
        for (int i = 0; i < room.length; i++) {
            /* Each row */
            int count = 0;
            for (int j = 0; j < room.length; j++) {
                /* Check area */
                if (room[i][j] == '.') {
                    count++;
                } else {
                    count = 0;
                }
                /* Update count */
                if (count == 2) {
                    rowCount++;
                }
            }
        }

        /* Count about col */
        int colCount = 0;
        for (int i = 0; i < room.length; i++) {
            /* Each row */
            int count = 0;
            for (int j = 0; j < room.length; j++) {
                /* Check area */
                if (room[j][i] == '.') {
                    count++;
                } else {
                    count = 0;
                }
                /* Update count */
                if (count == 2) {
                    colCount++;
                }
            }
        }


        /* Return result */
        return String.format("%d %d", rowCount, colCount);
    }

}