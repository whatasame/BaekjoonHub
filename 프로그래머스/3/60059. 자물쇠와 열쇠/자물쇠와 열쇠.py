# 자물쇠: n x n 
# 열쇠: m x m

# 홈: 0, 돌기: 1

# 열쇠: 회전, 이동 가능
# 자물쇠 영역을 벗어난 부분은 ㅇㅋ
# 자물쇠의 모든 홈을 채워 비어 있는 곳이 없어야 됨

# 자물쇠와 열쇠가 주어질 때 열 수 있는지 여부 반환

"""
[
    [1, 1, 1],
    [1, 1, 1],
    [1, 1, 1]
]
[
    [0, 0, 0],
    [0, 0, 0],
    [0, 0, 0]
]
-> true

[
    [0, 0, 0],
    [0, 0, 0],
    [0, 0, 0]
]
[
    [1, 1, 1],
    [1, 1, 1],
    [1, 1, 1]
]
-> true

[
    [0, 1, 0],
    [1, 0, 0],
    [0, 1, 0]
]
[
    [0, 1, 1],
    [1, 1, 1],
    [0, 1, 1]
]
-> true

[
    [0, 1, 0],
    [1, 0, 1],
    [0, 1, 0]
]
[
    [0, 1, 1],
    [1, 1, 1],
    [0, 1, 1]
]
-> false

[
    [0, 1, 0],
    [1, 0, 1],
    [0, 1, 0]
]
[
    [0, 1, 0],
    [1, 0, 1],
    [1, 1, 1]
]
-> true

[
    [0, 1, 0],
    [1, 0, 1],
    [0, 0, 0]
]
[
    [1, 1, 1, 1],
    [1, 1, 1, 1],
    [1, 0, 1, 0],
    [1, 1, 0, 1]
]
-> true

[
    [0, 0, 0, 0],
    [1, 0, 1, 1],
    [0, 1, 0, 0],
    [0, 0, 0, 0]
]
[
    [1, 1, 1, 1],
    [0, 0, 1, 1],
    [1, 1, 1, 1],
    [1, 1, 1, 1]
]
-> true
"""

import copy

def solution(key, _lock):
    n = len(_lock)
    total_zero = sum(row.count(0) for row in _lock)

    # lock padding
    lock = [[-1 for _ in range(n * 3)] for _ in range(n * 3)]
    for r in range(n):
        for c in range(n):
            lock[n + r][n + c] = _lock[r][c]

    # 자물쇠를 돌려가며
    for _ in range(4):
        for r in range(len(lock) - n):
            for c in range(len(lock) - n):
                # 조건에 맞게 들어맞는지 확인
                zero, one = check(lock, r, c, key)

                # 모든 홈이 채워지고 돌기는 없었는지 확인
                if zero == total_zero and one == 0:
                    return True

                    # 회전
        lock = rotate(lock)

    return False

def check(lock, r, c, key):
    zero_cnt, one_cnt = 0, 0

    # r, c에 key를 대봤을 때 zero와 one의 개수
    for kr in range(len(key)):
        for kc in range(len(key)):
            if key[kr][kc] != 1:
                continue

            if lock[r + kr][c + kc] == 0:
                zero_cnt += 1
            elif lock[r + kr][c + kc] == 1:
                one_cnt += 1

    return zero_cnt, one_cnt

def rotate(arr):
    n = len(arr)

    return [[arr[c][n - 1 - r] for c in range(n)] for r in range(n)]
