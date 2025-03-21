// 작업: 번호, 요청 시각, 소요 시간
// 우선순위 1. 짧은 소요시간, 2. 빠른 요청 시각, 3. 작은 작업 번호
// 평균 반환 시간의 정수부를 반환

// 특정 시점에 대기 큐에 아무것도 없을 수도 있다.

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시각 빠른 순으로 정렬 O(nlogn);
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        // waiting queue - 소요 시간을 제외한 나머지 요소는 최적화에 영향 x
        Queue<int[]> wq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int total = 0;
        int timer = 0;
        int idx = 0;
        int completed = 0;
        
        while (completed < jobs.length) {
            // 현재 시간에 대기중인 작업을 찾아 큐에 추가
            while (idx < jobs.length && jobs[idx][0] <= timer) {
                wq.add(jobs[idx]);
                idx += 1;
            }
            
            // 현재 대기중인 작업이 없으면 가장 빠른 작업 시간으로 점프
            if (wq.isEmpty()) {
                timer = jobs[idx][0];
                continue;
            }
            
            int[] job = wq.poll();
            timer += job[1];
            total += timer - job[0];
            completed += 1;
        }
        
        return total / jobs.length;
    }
}