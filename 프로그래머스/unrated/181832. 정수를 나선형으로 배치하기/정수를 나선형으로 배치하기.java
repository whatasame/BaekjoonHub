/*
col 증가 -> row 증가 -> col 감소 -> row 감소 -> ...
flags = {0, 1, 2, 3}
*/

class Solution {
    
    static int n;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public Point move(int flag, Point point) {
        int nr = point.row + dr[flag];
        int nc = point.col + dc[flag];
        
        return new Point(nr, nc);
    }
    
    public int[][] solution(int _n) {
        n = _n;
        
        // n * n 배열 생성
        int[][] answer = new int[n][n];
        
        // 1부터 n^2까지 대입
        int flag = 0;
        Point point = new Point(0, 0);
        for (int num = 1; num <= n * n; num++) {
            // 정수 배치
            answer[point.row][point.col] = num;
            
            // 다음 위치 계산
            Point np = move(flag, point);
            
            // 다음 위치가 out of index이거나 0이 아니라면 방향 전환해서 한 칸 이동
            if (isOutOfIndex(np) || answer[np.row][np.col] != 0) {
                flag = (flag + 1) % 4;
                point = move(flag, point);
            }
            // 정상적이라면 그냥 한 칸 이동
            else {
                point = np;
            }
        }
        
        return answer;
    }
    
    static class Point {
        int row;
        int col;
        
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private boolean isOutOfIndex(Point point) {
        return point.row >= n || point.row < 0 || point.col >= n || point.col < 0;
    }
}