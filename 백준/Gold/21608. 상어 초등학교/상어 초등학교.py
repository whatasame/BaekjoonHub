# 학생의 만족도 총 합을 반환

# 인접 좋아하는 학생
# 인접 빈 칸 많은
# 행 번호 -> 열 번호 작은 순

import sys
from collections import defaultdict

input = sys.stdin.readline
directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

n = int(input())
data = {}
for _ in range(n ** 2):
    nums = list(map(int, input().split()))
    data[nums[0]] = set(nums[1:])

def solution(n, data):
    board = [[None for _ in range(n)] for _ in range(n)]

    for student, likes in data.items():
        r, c = play(board, student, likes)
        board[r][c] = student

    return cal_score(board, data)

def play(board, student, likes):
    global n, directions

    # 인접 좋아하는 학생
    like_score = defaultdict(list)
    for r in range(n):
        for c in range(n):
            if board[r][c]:
                continue

            cnt = 0
            for nr, nc in adjacent(r, c):
                if board[nr][nc] in likes:
                    cnt += 1
            like_score[cnt].append((r, c))
    max_like = max(like_score)
    if len(like_score[max_like]) == 1:
        return like_score[max_like][0]

    # 인접 빈 칸 많은
    blank_score = defaultdict(list)
    for r, c in like_score[max_like]:
        if board[r][c]:
            continue

        cnt = 0
        for nr, nc in adjacent(r, c):
            if not board[nr][nc]:
                cnt += 1
        blank_score[cnt].append((r, c))

    # 행 번호 작은, 열 번호 작은
    return min(blank_score[max(blank_score)])

def adjacent(r, c):
    global n, directions

    result = []
    for dr, dc in directions:
        nr, nc = r + dr, c + dc
        if not (0 <= nr < n and 0 <= nc < n):
            continue
        result.append((nr, nc))

    return result

def cal_score(board, data):
    global n, directions

    score = 0
    for r, row in enumerate(board):
        for c, student in enumerate(row):

            # 인접한 좋아하는 학생 카운트
            cnt = 0
            for nr, nc in adjacent(r, c):
                if board[nr][nc] in data[student]:
                    cnt += 1

            if cnt:
                score += 10 ** (cnt - 1)

    return score

print(solution(n, data))
