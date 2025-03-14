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
        // 새로운 사각형 내부는 이동 불가
        // 겹친 점은 이동 가능
        // 겹치면서 다른 사각형의 내부는 이동 불가
        int[][] map = new int[MAX_LEN][MAX_LEN];
        for (int i = 0; i < rectangles.length; i++) {
            draw(map, rectangles[i], i + 1);
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
                if (map[nx][ny] <= 0 || costs[nx][ny] != 0) continue;
                
                queue.offer(new Pair(nx, ny));
                costs[nx][ny] = cost + 1;
            }
        }
        
        
        return 0;
    }
    
    void draw(int[][] map, int[] rectagle, int value) {
        // padding
        int lbx = rectagle[0] * 2; // left bottom
        int lby = rectagle[1] * 2;
        int rtx = rectagle[2] * 2; // right top
        int rty = rectagle[3] * 2;
        
        // 내부: -1
        for (int x = lbx + 1; x < rtx; x++) {
            for (int y = lby + 1; y < rty; y++) {
                map[x][y] = -1;
            }
        }
        
        // 테두리: 1
        for (int x = lbx; x <= rtx; x++) {
            map[x][lby] = map[x][lby] == -1 ? -1 : value;
            map[x][rty] = map[x][rty] == -1 ? -1 : value;
        }
        for (int y = lby; y <= rty; y++) {
            map[lbx][y] = map[lbx][y] == -1 ? -1 : value;
            map[rtx][y] = map[rtx][y] == -1 ? -1 : value;
        }
    }
    
    static class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}