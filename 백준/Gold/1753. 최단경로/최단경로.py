import heapq
import sys


def dijkstra(K):
    hq = []

    costs[K] = 0
    heapq.heappush(hq, (costs[K], K))

    while hq:
        cost, u = heapq.heappop(hq)

        if cost > costs[u]: # visited 처리
            continue

        for v, w in graph[u]:
            nw = costs[u] + w

            if nw < costs[v]:
                costs[v] = nw
                heapq.heappush(hq, (costs[v], v))


if __name__ == '__main__':
    # 입력
    V, E = map(int, input().split())
    K = int(input())
    INF = 2 ** 31

    graph = [[] for _ in range(V + 1)]
    costs = [INF] * (V + 1)

    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u].append((v, w))

    # 해결
    dijkstra(K)

    # 출력
    for i in range(1, V + 1):
        print(costs[i] if costs[i] != INF else "INF")
