// 작업: 번호, 요청 시각, 소요 시간
// 우선순위 1. 짧은 소요시간, 2. 빠른 요청 시각, 3. 작은 작업 번호
// 평균 반환 시간의 정수부를 반환

// 특정 시점에 대기 큐에 아무것도 없을 수도 있다.

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Queue<Task> wq = new PriorityQueue<>((t1, t2) -> { // waiting queue
            if (t1.cost == t2.cost) {
                if (t1.request == t2.request) {
                    return t1.num - t2.num;
                }
                return t1.request - t2.request;
            }
            return t1.cost - t2.cost;
        });
        Queue<Task> jq = new PriorityQueue<>((t1, t2) -> t1.request - t2.request); // job queue
        for (int i = 0; i < jobs.length; i++) {
            jq.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        while (!jq.isEmpty() || !wq.isEmpty()) {
            // 현재 시간에 대기하는 작업 추가
            while (!jq.isEmpty() && jq.peek().request <= time) {
                wq.add(jq.remove());
            }
            
            // 대기 작업이 없다면 다음 초로
            if (wq.isEmpty()) {
                time += 1;
                continue;
            }
            
            // 대기중인 작업 처리
            Task now = wq.remove();
            time += now.cost;
            answer += time - now.request;
        }
        
        return answer / jobs.length;
    }
    
    static class Task {
        
        int num, request, cost; 
        
        Task(int num, int request, int cost) {
            this.num = num;
            this.request = request;
            this.cost = cost;
        }
    }
}