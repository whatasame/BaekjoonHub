"""
1 1
7
-> 1

3 100
1 2 3
-> 0

3 6
1 2 3
3
"""

import sys

input = sys.stdin.readline
n, s = map(int, input().split())
nums = list(map(int, input().split()))

def solution(n, s, nums):
    answer = float("inf")
    end = 0
    total = nums[0]

    for start in range(n):
        while end < n and total < s:
            end += 1
            if end != n:
                total += nums[end]

        if end == n:
            break

        length = end - start + 1
        answer = min(answer, length)

        total -= nums[start]

    return answer if answer != float("inf") else 0

print(solution(n, s, nums))
