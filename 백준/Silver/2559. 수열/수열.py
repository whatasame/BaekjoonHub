"""
5 3
1 2 3 4 5
-> 12
"""

import sys

input = sys.stdin.readline
n, k = map(int, input().split())
nums = list(map(int, input().split()))

def solution(n, k, nums):
    nums = [0] + nums
    sums = [0 for _ in range(n + 1)]

    # 누적합 구하기
    for idx in range(1, n + 1):
        sums[idx] = sums[idx - 1] + nums[idx]

    answer = float("-inf")
    for idx in range(1, n + 1 - (k - 1)):
        result = sums[idx + k - 1] - sums[idx - 1]
        answer = max(result, answer)

    return answer

print(solution(n, k, nums))
