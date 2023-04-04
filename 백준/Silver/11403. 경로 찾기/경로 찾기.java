import java.io.*;
import java.util.*;

public class Main {

    private static int[][] graph;

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        N = Integer.parseInt(br.readLine());

        /* Generate directed graph */
        graph = new int[N][N]; // Vertex: 0 to N-1
        for (int u = 0; u < N; u++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int v = 0; v < N; v++) {
                graph[u][v] = Integer.parseInt(st.nextToken()); // Edge<u, v>
            }
        }

        /* Run solution */
        int[][] path = solution();

        /* Print path */
        StringBuilder sb = new StringBuilder();
        for (int[] u : path) {
            for (int v : u) {
                sb.append(v).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    private static int[][] solution() {
        int[][] path = new int[N][N];

        /* BFS all vertex */
        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                path[u][v] = bfs(u, v) ? 1 : 0;
            }
        }

        return path;
    }

    private static boolean bfs(int from, int to) {
        boolean[] isVisited = new boolean[N];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        isVisited[from] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int neighbor = 0; neighbor < N; neighbor++) {
                if (graph[vertex][neighbor] == 1) {
                    if (neighbor == to) { // Path{from - to} exist
                        return true;
                    }
                    if (!isVisited[neighbor]) {
                        queue.offer(neighbor);
                        isVisited[neighbor] = true;
                    }
                }
            }

        }

        return false;
    }

}