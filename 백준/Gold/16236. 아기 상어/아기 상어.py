## 문제 분석
# NxN -> 0: 빈 공간, 1~6: 물고기, 9: 상어 (유일)
# 최초 size: 2
# 상어 이동: 상하좌우 1칸, 상어보다 큰 물고기는 못 지나감
# 먹는 조건: 상어보다 작을 때
# 먹는 기준: 가장 짧은 거리 -> 가장 위 -> 가장 왼쪽
# 못 먹을 때까지 걸리는 시간?

from collections import deque


def solution():
    timer = 0
    size = 2
    ate = 0

    # 상어 위치 찾기
    sx, sy = -1, -1
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 9:
                sx, sy = i, j

    while True:
        # 현재 위치에서 가장 가까운 먹이감 찾기
        target_list = get_target_list(size, sx, sy)
        if not target_list:
            break

        # 최종 먹이감 결정
        target = min(target_list, key=lambda t: (t[0], t[1]))

        # 먹기
        tx, ty, dist = target
        graph[sx][sy] = 0
        graph[tx][ty] = 9
        timer += dist
        ate += 1
        if ate == size:
            size += 1
            ate = 0
        sx, sy = tx, ty

    return timer


def get_target_list(size, sx, sy):
    target_list = []

    # BFS
    q = deque()
    dist_list = [[-1 for _ in range(N)] for _ in range(N)]
    min_dist = None  # 최단 거리

    q.append((sx, sy))
    dist_list[sx][sy] = 0

    while q:
        x, y = q.popleft()

        for dx, dy in d:
            nx = x + dx
            ny = y + dy

            if not (0 <= nx < N and 0 <= ny < N):
                continue

            if 0 <= graph[nx][ny] <= size and dist_list[nx][ny] == -1:
                q.append((nx, ny))
                dist_list[nx][ny] = dist_list[x][y] + 1
                if 0 < graph[nx][ny] < size:  # 먹이감 후보
                    if min_dist is None:  # 최초 발견 물고기
                        min_dist = dist_list[nx][ny]
                        target_list.append((nx, ny, dist_list[nx][ny]))
                    elif dist_list[nx][ny] == min_dist:  # 최단 거리 물고기
                        target_list.append((nx, ny, dist_list[nx][ny]))
                    else:  # 최단 거리가 아닌 물고기
                        return target_list

    return target_list


if __name__ == "__main__":
    # 입력
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]

    # 해결
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    answer = solution()

    # 출력
    print(answer)
