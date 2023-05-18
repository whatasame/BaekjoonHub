## 문제 분석
# 무방향 그래프
# 1번 마을에서 K 시간 안으로 배달 가능한 곳만 배달
# 배달 가능한 곳의 수를 출력

import heapq

def solution(N, road, K):
    INF = 987654321

    graph = [[] for _ in range(N + 1)] # 0, 1 to N
    for u, v, w in road:
        graph[u].append((v, w))
        graph[v].append((u, w))
    costs = [INF] * (N + 1)

    # 다익스트라 
    hq = []
    costs[1] = 0
    heapq.heappush(hq, (costs[1], 1))

    while hq:
        cost, u = heapq.heappop(hq)

        if cost > costs[u]:
            continue

        for v, w in graph[u]:
            new_cost = costs[u] + w

            if new_cost < costs[v]:
                costs[v] = new_cost
                heapq.heappush(hq, (costs[v], v))

    return len([cost for cost in costs if cost <= K])