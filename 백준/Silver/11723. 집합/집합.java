import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        Set set = new Set(20);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            final String operator = st.nextToken();
            switch (operator) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.check(Integer.parseInt(st.nextToken())))
                            .append('\n');
                    break;
                case "toggle":
                    set.toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    set.all();
                    break;
                case "empty":
                    set.empty();
                    break;
            }

        }
        System.out.println(sb);

        br.close();
    }
}

class Set {

    int capacity;
    boolean[] exists;

    Set(int capacity) {
        this.capacity = capacity + 1; // 1 to capacity;
        exists = new boolean[this.capacity];
    }

    public void add(int x) {
        if (check(x) == 0) {
            exists[x] = true;
        }
    }

    public void remove(int x) {
        if (check(x) == 1) {
            exists[x] = false;
        }
    }

    public int check(int x) {
        return exists[x] ? 1 : 0;
    }

    public void toggle(int x) {
        if (check(x) == 1) {
            remove(x);
        } else {
            add(x);
        }
    }

    public void all() {
        Arrays.fill(exists, true);
    }

    public void empty() {
        Arrays.fill(exists, false);
    }
}