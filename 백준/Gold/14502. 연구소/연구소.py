## 문제 분석
# NxM 직사각형
# 0: 빈칸, 1: 벽, 2: 바이러스
# 바이러스는 상하좌우로 퍼진다
# 기존 지도에 추가로 벽을 3개 세워야 함
# 추가로 벽을 세워서 안전 영역의 크기를 구하라

## 아이디어
# 1. 벽을 세우는 경우의 수 -> 조합
# 2. 바이러스 전파 -> BFS, DFS


import copy
from itertools import combinations

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

answer = 0
empty = [(r, c) for r in range(N) for c in range(M) if arr[r][c] == 0]  # 벽을 세울 수 있는 공간들

for walls in combinations(empty, 3):
    # 벽 세우기
    tmp = copy.deepcopy(arr)
    for x, y in walls:
        tmp[x][y] = 1

    # 바이러스 전파
    virus = [(x, y) for x in range(N) for y in range(M) if tmp[x][y] == 2]
    while virus:
        x, y = virus.pop()
        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < M and tmp[nx][ny] == 0:
                tmp[nx][ny] = 2
                virus.append((nx, ny))

    # 안전 구역 구하기
    cnt = sum(map(lambda row: row.count(0), tmp))
    answer = max(answer, cnt)

print(answer)
