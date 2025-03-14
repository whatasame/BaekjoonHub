// 지형은 반드시 겹쳐서 표현된다.
// 겹친 경우 안쪽으로 갈 순 없고 다각형의 가장 바깥쪽 테두리만 이동할 수 있다.
// 이동은 동서남북
// 비용은 1칸

import java.util.*;
import java.util.stream.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int MAX_LEN = 101; // 1-base
    
    public int solution(int[][] rectangles, int cx, int cy, int ix, int iy) {
        // 캐릭터가 이동할 수 있는 지도 초기화
        int[][] map = new int[MAX_LEN][MAX_LEN];
        for (int[] rectangle : rectangles) {
            // padding
            int lbx = rectangle[0] * 2; // left bottom
            int lby = rectangle[1] * 2;
            int rtx = rectangle[2] * 2; // right top
            int rty = rectangle[3] * 2;

            // 사각형 전 영역 칠하기
            for (int x = lbx; x <= rtx; x++) {
                for (int y = lby; y <= rty; y++) {
                    map[x][y] = 1;
                }
            }
        }
        for (int[] rectangle : rectangles) {
            int lbx = rectangle[0] * 2; 
            int lby = rectangle[1] * 2;
            int rtx = rectangle[2] * 2;
            int rty = rectangle[3] * 2;

            // 사각형 내부 비우기
            for (int x = lbx + 1; x < rtx; x++) {
                for (int y = lby + 1; y < rty; y++) {
                    map[x][y] = 0;
                }
            }
        }
        
        
        // BFS
        cx *= 2; cy *= 2; ix *= 2; iy *= 2; // 길이가 1인 사각형의 내부를 만들기 위한 padding
        Queue<Pair> queue = new LinkedList<>();
        int[][] costs = new int[MAX_LEN][MAX_LEN];
        queue.offer(new Pair(cx, cy));
        costs[cx][cy] = 0;
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int x = current.x;
            int y = current.y;
            int cost = costs[x][y];
            
            if (x == ix && y == iy) {
                return cost / 2; // padding 보정
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= MAX_LEN || nx < 0 || ny >= MAX_LEN || ny < 0) continue;
                if (map[nx][ny] == 0|| costs[nx][ny] != 0) continue;
                
                queue.offer(new Pair(nx, ny));
                costs[nx][ny] = cost + 1;
            }
        }
        
        return -1;
    }
    
    static class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}