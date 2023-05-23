## 문제 분석
# (0, 0)부터 (N-1, M-1)까지 이동
# 벽을 딱 하나!! 부술 수 있음. 이때 최단 경로(지나간 칸 수)를 출력 -> BFS
# 벽을 언제 부술 것인가? 지금 벽을 부수는 경우(예제 1)와 나중에 벽을 부수는 경우
# 지금 벽을 부술 때와 벽을 안 부수는 경우를 고려 -> [x][y][wall]: wall == 0: 벽 안뿌, 1: 벽 뿌

""" 추가 테스트 케이스 (나중에 벽을 부숴야 최단 경로) >> 9
6 4
0000
1110
1000
0000
0111
0000
"""

from collections import deque


def bfs():
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    cost = [[[0 for _ in range(2)] for _ in range(M)] for _ in range(N)]

    q = deque()
    q.append((0, 0, 0))  # (x, y, wall)
    cost[0][0][0] += 1

    while q:
        x, y, w = q.popleft()

        if x == N - 1 and y == M - 1:  # N, M에 도착
            return cost[x][y][w]

        for dx, dy in d:
            nx = x + dx
            ny = y + dy

            if not 0 <= nx < N or not 0 <= ny < M:  # 인덱스 검사
                continue

            # 방문하지 않은 길
            if arr[nx][ny] == 0 and cost[nx][ny][w] == 0:
                q.append((nx, ny, w))
                cost[nx][ny][w] = cost[x][y][w] + 1
            # (x, y)까지 오는데 벽을 부순 적이 없음
            elif arr[nx][ny] == 1 and w == 0:
                q.append((nx, ny, w + 1))
                cost[nx][ny][w + 1] = cost[x][y][w] + 1

    return -1  # N, M에 도착하지 못함


if __name__ == "__main__":
    # 입력
    N, M = map(int, input().split())
    arr = [list(map(int, input())) for _ in range(N)]

    # 해결
    answer = bfs()

    # 출력
    print(answer)
