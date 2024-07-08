// 격자판은 무한히 넓다
// 정수로 표현되는 교점만 센다

// AD = BC인 경우 평행하다.

// A 혹은 B 중 하나는 0일 수 있다.

import java.util.*;

class Solution {
    
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();
        
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE; 
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                double a = line[i][0];
                double b = line[i][1];
                double e = line[i][2];
                double c = line[j][0];
                double d = line[j][1];
                double f = line[j][2];
                
                if (a * d == b * c) { // parellel
                    continue;
                }
                
                double rx = (b * f - e * d) / (a * d - b * c); // result x
                double ry = (e * c - a * f) / (a * d - b * c); // result y
                
                if (Math.floor(rx) != rx || Math.floor(ry) != ry) {
                    continue;
                }
                
                long x = (long) rx;
                long y = (long) ry;
                
                points.add(new Point(x , y));
                
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
        
        int n = (int) (maxY - minY) + 1;
        int m = (int) (maxX - minX) + 1;
        
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = '.';
            }
        }

        for (Point point : points) {
            int nx = (int) (point.x - minX);
            int ny = (int) (maxY - point.y);
            
            board[ny][nx] = '*';
        }
        
        String[] answer = new String[board.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(board[i]);
        }
        
        return answer;
    }
    
    static class Point {
        long x, y;
        
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}