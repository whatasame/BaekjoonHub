# 0: 1 (5^0)
# 1: 11011 (5^1)
# 2: 11011 11011 00000 11011 11011 (5^2)
# n: ... (5^n = 5^20 = 95,367,431,640,625)

def solution(n, l, r):
    return cnt(n, r - 1) - cnt(n, l - 2) # 1-base -> 0-base [l - 1, r - 1] = [0, r - 1] - [0, l - 2]
    
def cnt(k, i): # k번째 비트열에서 i번째까지 1의 개수
    if i < 0:
        return 0
    
    if k == 0:
        return 1
    
    section_length = 5 ** (k - 1) # k-1번째 비트열의 길이
    section_idx = i // section_length # k번째 비트열의 i번째 숫자를 만든 k-1번째 비트열의 위치
    ones_cnt = 4 ** (k - 1) # k-1번째 비트열에서 1의 개수
        
    if section_idx < 2: # '11'011 
        return section_idx * ones_cnt + cnt(k - 1, i - section_idx * section_length)
    elif section_idx == 2: # 11'0'11 
        return 2 * ones_cnt
    else: # 110'11'
        return (section_idx - 1) * ones_cnt + cnt(k - 1, i - section_idx * section_length)

        
    