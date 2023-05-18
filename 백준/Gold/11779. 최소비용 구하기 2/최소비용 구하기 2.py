import heapq
import sys


def dijkstra(s):
    hq = []

    costs[s] = 0
    heapq.heappush(hq, (costs[s], s))

    while hq:
        cost, u = heapq.heappop(hq)

        if cost > costs[u]:
            continue

        for v, w in graph[u]:
            new_cost = costs[u] + w

            if new_cost < costs[v]:
                costs[v] = new_cost
                path[v] = u
                heapq.heappush(hq, (costs[v], v))


if __name__ == "__main__":
    # 입력
    input = sys.stdin.readline
    INF = 987654321

    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
    START, END = map(int, input().split())

    # 해결
    costs = [INF] * (N + 1)
    path = [i for i in range(N + 1)]
    dijkstra(START)
    
    answer = []
    tmp = END
    while tmp != START:
        answer.append(tmp)
        tmp = path[tmp]
    answer.append(tmp)

    # 출력
    print(costs[END])
    print(len(answer))
    print(" ".join(map(str, answer[::-1])))
