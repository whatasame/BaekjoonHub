# heapq vs deque: https://www.acmicpc.net/board/view/116324

import sys
from collections import deque

input = lambda:sys.stdin.readline().strip()

t = int(input())
cases = [tuple(map(int, input().split())) for _ in range(t)]

def solution(cases):
    return [run(*case) for case in cases]

def run(origin, target):
    visited = [False] * 10_000
    q = deque([(origin, "")])
    while q:
        num, commands = q.popleft()

        if num == target:
            return commands

        d_num = d(num)
        if not visited[d_num]:
            visited[d_num] = True
            q.append((d_num, commands + "D"))

        s_num = s(num)
        if not visited[s_num]:
            visited[s_num] = True
            q.append((s_num, commands + "S"))

        l_num = l(num)
        if not visited[l_num]:
            visited[l_num] = True
            q.append((l_num, commands + "L"))

        r_num = r(num)
        if not visited[r_num]:
            visited[r_num] = True
            q.append((r_num, commands + "R"))


def d(num):
    return num * 2 % 10_000

def s(num):
    return 9_999 if num == 0 else num - 1

def l(num):
    string = "0000" + str(num)
    string = string[-4:]
    string = string[1:] + string[0]

    return int(string)

def r(num):
    string = "0000" + str(num)
    string = string[-4:]
    string = string[-1] + string[:-1]

    return int(string)

print("\n".join(solution(cases)))
