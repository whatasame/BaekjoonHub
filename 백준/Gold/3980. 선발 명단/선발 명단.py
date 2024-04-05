# 포지션 별로 한 명 씩 배치했을 때 능력치의 합이 최대를 반환

# 11! = 39_916_800

import sys

input = lambda:sys.stdin.readline().strip()

c = int(input())
cases = [[list(map(int, input().split())) for _ in range(11)] for _ in range(c)]
result = 0

def solution(cases):
    global result

    answer = []
    for case in cases:
        result = 0
        dfs(case, 0, set(), 0)
        answer.append(result)

    return answer

def dfs(case, player, selected, score):
    global result
    if player == 11:
        result = max(result, score)

    for position in range(11):
        if position in selected or case[player][position] == 0:
            continue

        selected.add(position)
        dfs(case, player + 1, selected, score + case[player][position])
        selected.remove(position)

print("\n".join(map(str, solution(cases))))
