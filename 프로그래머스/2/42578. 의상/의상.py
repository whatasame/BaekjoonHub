# 의상 개수 1 <= n <= 30
# 옷의 종류 1 <= m <= 30
from collections import *

def solution(clothes):
    # 각 부위별 옷의 개수 구하기: O(n)
    kind_to_count = defaultdict(int)
    for cloth, kind in clothes:
        kind_to_count[kind] += 1
        
    # 각 종류별 (옷의 개수 + 1) 곱하기: O(m)
    answer = 1
    for count in kind_to_count.values():
        answer *= (count + 1)
        
    # 아무것도 입지 않는 경우 제외
    return answer - 1
        
