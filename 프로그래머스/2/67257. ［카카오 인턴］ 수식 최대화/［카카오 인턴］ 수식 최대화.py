# 절대값이 가장 큰 숫자가 우승
# 절대값 = 우승 금액
# 우승 금액을 반환

import re, heapq
from itertools import permutations

def solution(expression):
    # 토큰화
    pattern = re.compile(r"(\d+|[-+*])")
    tokens = pattern.findall(expression)

    # 모든 우선 순위에 대하여
    answer = 0
    for first, second, third in permutations("-+*", 3):
        second_result = []
        for second_target in expression.split(third):
            first_result = []
            for first_target in second_target.split(second):
                first_result.append(str(eval(first_target)))
                
            second_result.append(str(eval(second.join(first_result))))

        result = abs(eval(third.join(second_result)))
        
        answer = max(answer, result)

    return answer
