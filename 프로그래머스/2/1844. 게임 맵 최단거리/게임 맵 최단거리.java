// 도착하지 못하면 -1 반환

import java.util.*;

class Solution {

    static int n, m;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] costs = new int[n][m];
        q.add(new Pair(0, 0));
        costs[0][0] = 1;

        int answer = -1;
        while (!q.isEmpty()) {
            Pair now = q.remove();

            if (now.r == n - 1 && now.c == m - 1) {
                answer = costs[now.r][now.c];
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (oob(nr, nc) || costs[nr][nc] != 0) continue;
                if (maps[nr][nc] == 0) continue;

                q.add(new Pair(nr, nc));
                costs[nr][nc] = costs[now.r][now.c] + 1;
            }
        }

        return answer;

    }

    boolean oob(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
