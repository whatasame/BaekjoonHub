import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        String[] unheardList = new String[N];
        for (int i = 0; i < N; i++) {
            unheardList[i] = br.readLine();
        }
        String[] unsawList = new String[M];
        for (int i = 0; i < M; i++) {
            unsawList[i] = br.readLine();
        }

        /* Run solution */
        Queue<String> unheardAndUnsaw = solution(unheardList, unsawList);

        /* Print result */
        StringBuilder sb = new StringBuilder();
        sb.append(unheardAndUnsaw.size()).append('\n');
        while (!unheardAndUnsaw.isEmpty()) {
            sb.append(unheardAndUnsaw.poll()).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    private static Queue<String> solution(String[] unheardList, String[] unsawList) {
        Queue<String> unheardAndUnsaw = new PriorityQueue<>(); // dictionary order heap

        /* Generate unheardSet */
        Set<String> unheardSet = new HashSet<>();
        for (String name : unheardList) {
            unheardSet.add(name);
        }

        /* Check all unsawList */
        for (String name : unsawList) {
            // if name does exist in set -> unheardAndUnsaw
            if (unheardSet.contains(name)) {
                // add name to unheardAndUnsaw
                unheardAndUnsaw.add(name);
            }
        }

        return unheardAndUnsaw;
    }

}