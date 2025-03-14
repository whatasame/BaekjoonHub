// 서로소 집합의 개수를 반환

import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        // 서로소 집합을 모두 구한 후
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] != 1) continue;
                
                union(parents, i, j);
            }
        }
        
        // 서로소 집합의 리스트의 고유 값의 개수를 반환        
        return (int) IntStream.range(0, n)
            .map (i -> findParent(parents, i))
            .distinct()
            .count();
    }
    
    void union(int[] parents, int n1, int n2) {
        int p1 = findParent(parents, n1);
        int p2 = findParent(parents, n2);
        
        if (p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }
    
    int findParent(int[] parents, int node) {
        if (parents[node] == node) return node; // root
        
        return parents[node] = findParent(parents, parents[node]);
    }
}