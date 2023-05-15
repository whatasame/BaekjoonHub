## 문제 분석
# -1: 빈 칸, 0: 토마토, 1: 익은 토마토
# 모두 익지 못하는 상황이면 -1을 출력

## 아이디어
# 최소 날짜 -> BFS
# BFS의 시작 지점이 다름 -> 큐에 시작 토마토를 모두 넣고 BFS를 한다.

## 추가 테스트 케이스
""" 0
3 2
1 1 1
1 1 1
"""

from collections import deque


def bfs(ts):
    q = deque()
    for t in ts:
        q.append(t)
        x, y = t
        cost[x][y] = 0  # 시작 지점 = 0일

    while q:
        x, y = q.popleft()

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0 and cost[nx][ny] == -1:
                q.append((nx, ny))
                cost[nx][ny] = cost[x][y] + 1


if __name__ == '__main__':
    # 입력
    M, N = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]

    # 해결
    tomatoes = [(x, y) for x in range(N) for y in range(M) if arr[x][y] == 1]
    cost = [[-1 for _ in range(M)] for _ in range(N)]
    bfs(tomatoes)

    # 출력
    answer = 0
    for i in range(N):
        for j in range(M):
            if cost[i][j] == -1 and arr[i][j] != -1:
                print(-1)
                exit(0)
            answer = max(answer, cost[i][j])
    print(answer)
