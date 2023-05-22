## 문제 분석
# 방향성 그래프
# X로 갈 때: from 1 ~ N to X의 거리
# 집에 돌아올 때: from X to 1 ~ N의 거리

import heapq
import sys


def dijkstra(start, g):
    dist_list = [INF] * (N + 1)
    hq = []
    dist_list[start] = 0
    hq.append((dist_list[start], start))

    while hq:
        dist, u = heapq.heappop(hq)

        if dist > dist_list[u]:
            continue

        for v, w in g[u]:
            new_dist = dist_list[u] + w

            if new_dist < dist_list[v]:
                dist_list[v] = new_dist
                heapq.heappush(hq, (dist_list[v], v))

    return dist_list[1:]


if __name__ == "__main__":
    # 입력
    input = sys.stdin.readline
    N, M, X = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    r_graph = [[] for _ in range(N + 1)]  # reverse direction graph
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
        r_graph[v].append((u, w))

    # 해결
    INF = 987654321
    dist_list = dijkstra(X, graph) 
    r_dist_list = dijkstra(X, r_graph)

    # 출력
    print(max(x + y for x, y in zip(dist_list, r_dist_list)))
