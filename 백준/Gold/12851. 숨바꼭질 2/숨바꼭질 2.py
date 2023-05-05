# 5 - 10 - 9 - 18 - 17
# 5 - 4  - 8 - 16 - 17

from collections import deque


def bfs():
    cnt = 0  # 등장 횟수
    q = deque()
    q.append(N)

    while q:
        pos = q.popleft()

        # 도착 검사
        if pos == K:
            cnt += 1
            continue # 예외 케이스: 5 5

        # 이동
        for new_pos in (pos + 1, pos - 1, pos * 2):
            if 0 <= new_pos <= MAX and \
                    (cost[new_pos] == cost[pos] + 1  # 같은 depth에서 넣은 것
                     or not cost[new_pos]):
                q.append(new_pos)
                cost[new_pos] = cost[pos] + 1

    return cnt


N, K = map(int, input().split())
MAX = 100000
cost = [0] * (MAX + 1)

count = bfs()

print(cost[K], count, sep='\n')
