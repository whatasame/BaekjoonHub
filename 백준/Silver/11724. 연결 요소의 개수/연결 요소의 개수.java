import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] graph;
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        /* Read N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* Init undirected graph */
        visited = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            /* Read edge(u, v) */
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            /* Add edge(u, v) */
            graph[u][v] = true;
            graph[v][u] = true;
        }

        /* Compute count of connected component */
        for (int i = 1; i <= N; i++) {
            if (dfs(i)) {
                count++;
            }
        }

        /* Print result */
        System.out.println(count);

        br.close();

    }

    public static boolean dfs(int vertex) {
        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;

        for (int i = 1; i < graph[vertex].length; i++) {
            if (graph[vertex][i]) {
                dfs(i);
            }
        }

        return true;
    }

}
