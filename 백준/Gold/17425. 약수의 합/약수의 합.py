import sys

input = sys.stdin.readline
t = int(input())
nums = [int(input()) for _ in range(t)]

def solution(nums):
    divided_sums = [0 for _ in range(1_000_001)]

    for num in range(1, 1_000_001):
        for times in range(num, 1_000_001, num):
            divided_sums[times] += num

        divided_sums[num] += divided_sums[num - 1]

    return [divided_sums[num] for num in nums]

print("\n".join(map(str, solution(nums))))
