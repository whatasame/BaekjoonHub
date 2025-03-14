// ICN에서 시작
// 간선이 두 개 이상인 경우 사전순
// 경로를 반환
// 모든 항공권 사용

import java.util.*;
import java.util.stream.*;

class Solution {
    
    String[][] tickets;
    List<String> routes = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0);
        
        Collections.sort(routes);
        
        return routes.get(0).split(" ");
    }
    
    void dfs(String airport, String route, int count) {
        if (count == tickets.length) { // 모든 항공권 사용
            routes.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if (!airport.equals(from) || visited[i]) continue;
            
            // 백트래킹
            visited[i] = true;
            dfs(to, route + " " + to, count + 1);
            visited[i] = false;
        }            
    }
}