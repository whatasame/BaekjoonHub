# 특정 숫자를 모두 제거할 때 가장 긴 연속된 숫자들의 길이를 반환

"""
8
2
7
3
7
7
3
7
7
-> 5

8
2
7
3
7
7
100
7
7
-> 4
"""

import sys
from collections import defaultdict

input = sys.stdin.readline
n = int(input())
numbers = [int(input())for _ in range(n)]

def solution(numbers):
    def longest_section(exclude):
        counts = defaultdict(int)

        bef = None
        count = 0
        for number in numbers:
            if number == exclude:
                continue

            if number == bef:
                count += 1
            else:
                count = 1

            counts[bef] = max(counts[bef], count)
            bef = number

        return max(counts.values())

    return max([longest_section(number) for number in numbers])

print(solution(numbers))
