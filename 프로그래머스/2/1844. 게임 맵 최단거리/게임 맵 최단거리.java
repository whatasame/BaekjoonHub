// (1, 1)에서 (n, m)으로 향하는 최단 경로의 길이
// 도착하지 못하는 경우 -1 반환

import java.util.*;
import java.util.stream.*;

class Solution {
    
    // EWSN
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Pair(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            
            if (current.r == n - 1 && current.c == m - 1) {
                return current.cost;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                
                if (nr >= n || nr < 0 || nc >= m || nc < 0) continue;
                if (maps[nr][nc] == 0 || visited[nr][nc]) continue;
                
                queue.offer(new Pair(nr, nc, current.cost + 1));
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    static class Pair {
        int r, c, cost;
        
        Pair(int r , int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}