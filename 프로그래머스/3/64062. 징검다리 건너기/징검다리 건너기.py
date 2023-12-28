# 디딤돌의 숫자만큼 밟을 수 있다
# 밟지 못하는 디딤돌은 건너뛴다.
# 밟을 수 있는 디딤돌이 여러 개인 경우 가장 가까운 디딤돌만 가능하다.

# 디딤돌 당 밟을 수 있는 최대 횟수: 2억

# k = 1, 최소 횟수만큼 이동할 수 있다?

def solution(stones, k):
    left, right = 1, 200_000_000
    
    answer = None
    while left <= right:
        middle = (left + right) // 2
        
        if movable(pre_run(stones, middle), k):
            left = middle + 1
        else:
            answer = middle
            right = middle - 1
            
    return answer

def movable(stones, k):
    zero_cnt = 0
    for stone in stones:
        if stone == 0:
            zero_cnt += 1
        else:
            zero_cnt = 0
        if zero_cnt >= k:
            return False
        
    return True
        
def pre_run(stones, m):
    return [stone - m if stone >= m else 0 for stone in stones]
