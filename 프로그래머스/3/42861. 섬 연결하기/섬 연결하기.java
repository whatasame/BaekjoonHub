// 모든 노드가 통행 가능 = MST

import java.util.*;

class Solution {
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // parent = 서로소 집합 대표
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) { // O(n)
            parent[i] = i;
        }
        
        // 비용으로 간선 정렬 
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]); // O(mlogm)
        
        // 모든 노드에 대하여 사이클이 없을 때 MST에 추가(서로소 집합 추가 및 비용 갱신)
        for (int i = 0; i < costs.length; i++) { // O(m)
            if (findParent(parent, costs[i][0]) == findParent(parent, costs[i][1])) {
                continue;
            }
            
            union(parent, costs[i][0], costs[i][1]);
            answer += costs[i][2];
        }
        
        return answer;
    }
    
    void union(int[] parent, int n1, int n2) {
        int p1 = findParent(parent, n1);
        int p2 = findParent(parent, n2);
        
        if (p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
    
    int findParent(int[] parent, int node) {
        if (parent[node] == node) return node;
        
        return parent[node] = findParent(parent, parent[node]);
    }
}