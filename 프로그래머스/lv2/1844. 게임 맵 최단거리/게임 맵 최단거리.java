import java.util.*;

// 출발 지점 (0, 0), 도착 지점 (n-1, m-1)
// 목표 지점에 못 도착할 수도 있다.

class Solution {
    
    private static int N, M;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
    
        /* BFS */
        int[][] length = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        length[0][0] = 1;
        queue.offer(new Node(0, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x == N-1 && now.y == M-1){ // 도착
                return length[now.x][now.y];
            }
            
            for(int i = 0; i < 4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                
                if(isValid(x, y) 
                  && maps[x][y] == 1
                  && length[x][y] == 0){
                    queue.offer(new Node(x, y));
                    length[x][y] = length[now.x][now.y] + 1; // 길이 업데이트
                } 
            }            
        }
        
        return -1; // 도착 하지 못함
    }
    
    private boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    static class Node{
        int x;
        int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}