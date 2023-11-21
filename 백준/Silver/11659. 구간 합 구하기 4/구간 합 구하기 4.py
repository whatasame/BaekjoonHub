import sys

input = sys.stdin.readline
n, m = map(int, input().split())
nums = list(map(int, input().split()))
sections = [tuple(map(int, input().split())) for _ in range(m)]

def solution(nums, sections):
    global n
    sums = [0 for _ in range(n + 1)]
    
    for idx in range(n):
        sums[idx + 1] = sums[idx] + nums[idx]
        
    answer = []
    for start, end in sections:
        result = sums[end] - sums[start - 1]
        answer.append(result)
        
    return answer

answer = solution(nums, sections)

print("\n".join(map(str, answer)))
