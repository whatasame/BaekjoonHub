import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] graph;

    private static boolean[] visited;

    private static int count = -1;

    public static void main(String[] args) throws IOException {
        /* Read input N, E */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        /* Init undirected graph */
        graph = new boolean[N + 1][N + 1];
        while (E-- > 0) {
            /* Read edge(u, v) */
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            /* Add edge(u, v) */
            graph[u][v] = true;
            graph[v][u] = true;
        }

        /* Infect computer connected with no.1 */
        visited = new boolean[N + 1];
        dfs(1);

        /* Print result */
        System.out.println(count);

        br.close();
    }

    public static void dfs(int vertex) {
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;
        count++;

        for (int i = 1; i < graph[vertex].length; i++) {
            if (graph[vertex][i]) {
                dfs(i);
            }
        }

    }
}
