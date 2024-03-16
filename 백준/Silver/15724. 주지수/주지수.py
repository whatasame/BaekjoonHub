# 주어진 직사각형 범위 내 총 사람 수를 반환

"""
4 5
1 2 3 4 5
6 7 8 9 1
2 3 4 5 6
7 8 9 1 2
1
2 2 3 3
-> 22
"""

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
k = int(input())
cases = [tuple(map(int, input().split())) for _ in range(k)]

def solution(board, cases):
    # 행, 열 누적합 배열 선언
    row = [[0 for _ in range(m + 1)] for _ in range(n + 1)] # row[n][m] -> n행의 m번째 행까지 합
    col = [[0 for _ in range(m + 1)] for _ in range(n + 1)] # col[n][m] -> m열의 n번째 행까지 합

    # 누적합 초기화
    for r in range(1, n + 1):
        for c in range(1, m + 1):
            row[r][c] = board[r - 1][c - 1] + row[r][c - 1]
    for c in range(1, m + 1):
        for r in range(1, n + 1):
            col[r][c] = board[r - 1][c - 1] + col[r - 1][c]

    # 각 케이스 계산
    answer = []
    for case in cases:
        sr, sc, er, ec = case

        result = sum(row[r][m] for r in range(er + 1))
        result -= sum(col[er][c] for c in range(sc))
        result -= sum(col[er][c] for c in range(ec + 1, m + 1))
        result -= sum(row[r][ec] - row[r][sc - 1] for r in range(sr))

        answer.append(result)

    return answer

print("\n".join(map(str, solution(board, cases))))
