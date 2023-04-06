import java.util.*;
import java.io.*;

// Vertex: 1 to N
// 서로 모르는 사람이 있지만 몇 사람을 통하면 모두가 알 수 있음 = 연결 그래프

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        N = Integer.parseInt(br.readLine());

        /* Generate undirected graph */
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            if (u == -1 && v == -1) {
                break;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        /* Run solution */
        List<Vertex> candidates = solution(graph);

        /* Print result */
        candidates.sort((v1, v2) -> {
            return v1.depth - v2.depth;
        });
        List<Vertex> results = new LinkedList<>();
        Vertex min = candidates.remove(0);
        results.add(min);
        for (Vertex candidate : candidates) {
            if (candidate.depth == min.depth) {
                results.add(candidate);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(results.get(0).depth).append(' ').append(results.size()).append('\n');
        for (Vertex result : results) {
            sb.append(result.num).append(' ');
        }
        System.out.println(sb);


        br.close();
    }

    private static List<Vertex> solution(List<List<Integer>> graph) {
        List<Vertex> candidates = new LinkedList<>();

        /* BFS all vertex */
        for (int i = 1; i <= N; i++) {
            boolean[] isVisited = new boolean[N + 1];
            Queue<Vertex> queue = new LinkedList<>();
            queue.offer(new Vertex(i, 0));
            isVisited[i] = true;

            int depth = -1;
            while (!queue.isEmpty()) {
                Vertex vertex = queue.poll();
                depth = vertex.depth;

                for (int neighbor : graph.get(vertex.num)) {
                    if (!isVisited[neighbor]) {
                        queue.offer(new Vertex(neighbor, depth + 1));
                        isVisited[neighbor] = true;
                    }
                }
            }

            candidates.add(new Vertex(i, depth));
        }

        return candidates;
    }

    private static class Vertex {
        int num;
        int depth;

        Vertex(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}