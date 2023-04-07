import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        int N = Integer.parseInt(br.readLine());

        /* Generate minheap */
        Queue<Integer> minHeap = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            minHeap.offer(Integer.parseInt(st.nextToken()));
        }

        /* Run solution */
        int result = solution(minHeap);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static int solution(Queue<Integer> minHeap) {
        int waitTime = 0, sum = 0;

        while (!minHeap.isEmpty()) {
            waitTime += minHeap.poll();
            sum += waitTime;
        }

        return sum;
    }

}