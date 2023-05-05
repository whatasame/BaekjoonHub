# 5 - 10 - 9 - 18 - 17
# 5 - 4  - 8 - 16 - 17

from collections import deque


def bfs():
    min_cost = 0  # 최소 시간
    cnt = 0  # 등장 횟수
    q = deque()
    q.append((N, 0))  # (위치, 시간)

    while q:
        now = q.popleft()
        visited[now[0]] = True

        # 도착 검사
        if now[0] == K:
            if not min_cost:  # 처음으로 도착
                min_cost = now[1]
                cnt += 1
            elif now[1] == min_cost:  # 최소 거리일 경우
                cnt += 1

        # 이동
        for moved in (now[0] + 1, now[0] - 1, now[0] * 2):
            if 0 <= moved <= MAX and not visited[moved]:
                q.append((moved, now[1] + 1))

    return min_cost, cnt


N, K = map(int, input().split())
MAX = 100000
visited = [False] * (MAX + 1)
answer = bfs()

print(answer[0], answer[1], sep='\n')
