import java.io.*;

public class Main {

    public static int run(int n){
        int[] count = new int[10_000_001];

        for (int start = 1; start <= 10_000_000; start++) {
            int num = start;
            count[num]++;

            for (int next = start + 1; num + next <= 10_000_000; next++) {
                num += next;
                count[num]++;
            }
        }

        return count[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = run(n);

        System.out.println(result);
    }
}
