import java.util.*;
import java.io.*;

public class Main {

    private static int[][] board;
    private static boolean[][] isVisited;
    private static int R;
    private static int C;
    private static final int[] offsetX = {0, 0, 1, -1};
    private static final int[] offsetY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        /* Init board */
        board = new int[R][C];
        isVisited = new boolean[R][C];
        for (int x = 0; x < R; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < C; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        /* Run solution */
        int[] result = solution();

        /* Print result */
        System.out.println(String.format("%s\n%s", result[0], result[1]));

        br.close();
    }

    private static int[] solution() {
        int count = 0, maxSize = 0;

        /* BFS about all position */
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (board[x][y] == 1 && !isVisited[x][y]) {
                    int size = bfs(x, y);

                    count++;
                    maxSize = Math.max(size, maxSize);
                }
            }
        }

        return new int[]{count, maxSize};
    }

    private static int bfs(int x, int y) {
        int size = 0;

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(new Vertex(x, y));
        isVisited[x][y] = true;
        size++;

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();

            for (int i = 0; i < offsetX.length; i++) {
                int newX = vertex.x + offsetX[i];
                int newY = vertex.y + offsetY[i];

                if (isValid(newX, newY) && board[newX][newY] == 1 && !isVisited[newX][newY]) {
                    queue.offer(new Vertex(newX, newY));
                    isVisited[newX][newY] = true;
                    size++;
                }
            }
        }

        return size;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private static class Vertex {
        int x;
        int y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}