# 포지션 별로 한 명 씩 배치했을 때 능력치의 합이 최대를 반환

# 11! = 39_916_800

import sys

input = lambda:sys.stdin.readline().strip()

c = int(input())
cases = [[list(map(int, input().split())) for _ in range(11)] for _ in range(c)]

def solution(cases):
    return [dfs(case, 0, set(), 0) for case in cases]

def dfs(case, player, selected, score):
    if player == 11:
        return score

    max_score = 0
    for position in range(11):
        if position in selected or case[player][position] == 0:
            continue

        selected.add(position)
        max_score = max(max_score, dfs(case, player + 1, selected, score + case[player][position]))
        selected.remove(position)

    return max_score

print("\n".join(map(str, solution(cases))))
