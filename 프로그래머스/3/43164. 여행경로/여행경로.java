// ICN에서 시작
// 간선이 두 개 이상인 경우 사전순
// 경로를 반환
// 모든 항공권 사용

import java.util.*;
import java.util.stream.*;

class Solution {
    
    Map<String, List<Airport>> graph = new HashMap<>();
    boolean[] visited;
    int total;
      
    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new Airport(to, i));
        }
    
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key), (a1, a2) -> a1.name.compareTo(a2.name));
        }
        
        List<String> route = new ArrayList<>(); 
        route.add("ICN");
        this.visited = new boolean[tickets.length];
        this.total = tickets.length + 1;
        
        dfs("ICN", route);
        
        return route.toArray(String[]::new);
    }
    
    boolean dfs(String current, List<String> route) {
        if (route.size() == total) return true; // 항공권 전부 사용
        
        if (!graph.containsKey(current)) return false; // 현재 위치에서 출발하는 티켓 없음
        
        for (Airport next : graph.get(current)) {
            if (visited[next.idx]) continue;

            // 백트래킹
            visited[next.idx] = true;
            route.add(next.name);
            if (dfs(next.name, route)) return true; // 바로 반환
            route.remove(route.size() - 1);
            visited[next.idx] = false;
        }
        
        return false;
    }
    
    static class Airport {
        String name;
        int idx; // 티켓 인덱스
        
        Airport(String name, int idx) {
            this.name = name;
            this.idx = idx;
        }
    }
}