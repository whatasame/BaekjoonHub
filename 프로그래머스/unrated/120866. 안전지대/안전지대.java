/*
지뢰 -> 1
땅 -> 1
*/

import java.util.*;

class Solution {
    
    static int n;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public void mark(boolean[][] mineMap, int row, int col) {
        for (int i = 0; i < dr.length; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                mineMap[nr][nc] = true;
            }
        }
    }
    
    public int solution(int[][] board) {
        // 위험 지도
        n = board.length;
        boolean[][] mineMap = new boolean[n][n];
        
        // 전체를 순회하면서 지뢰를 찾는다.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // 지뢰 발견시 위험 지도에 표시한다.
                if (board[row][col] == 1) {
                    // 지뢰 위치에 표시
                    mineMap[row][col] = true;
                    // 지뢰 주변에 표시
                    mark(mineMap, row, col);
                }
            }
        }
            
        // 위험 지도에서 안전한 칸의 개수를 반환한다.
        int count = 0;
        for (boolean[] row : mineMap) {
            for (boolean isMine : row) {
                if (!isMine) {
                    count++;
                } 
            }
        }
        
        return count;
    }
}
