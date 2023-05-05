from collections import deque


def bfs():
    q = deque()
    q.append(N)
    while q:
        i = q.popleft()
        if i == K:
            return cost[i]
        for next_i in (i - 1, i + 1, i * 2):
            if 0 <= next_i < MAX and not cost[next_i]:  # cost == 0 -> not visited
                cost[next_i] = cost[i] + 1
                q.append(next_i)


MAX = 100001
cost = [0] * MAX
N, K = map(int, input().split())

print(bfs())
