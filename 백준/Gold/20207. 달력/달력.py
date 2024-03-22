# 모든 일정을 포함하는 가장 작은 직사각형의 면적을 구하라

# 가로 길이 = 가장 큰 종료일
# 세로 길이는 전체 줄 수에 비례

"""
5
1 9
8 9
4 6
7 7
2 5
-> 27

7
4 5
2 4
5 6
5 7
7 9
11 12
12 12
-> 28
"""

import sys

input = lambda:sys.stdin.readline().strip()

n = int(input())
schedules = [tuple(map(int, input().split())) for _ in range(n)]

def solution():
    max_day = max(schedules, key=lambda s:s[1])[1]
    
    # idx: 날짜, val: 가능한 라인
    lines = [[0 for _ in range(max_day + 1)]] # 0 ~ max_day

    # 모든 일정에 대하여 -> O(n)
    for start, end in schedules:
        inserted = False
        # 들어갈 수 있는 라인 찾아서 넣기 -> O(n)
        for line in lines:
            if sum(line[start:end+1]) != 0:
                continue
            for day in range(start, end + 1):
                line[day] = 1
                inserted = True
            break
        # 다른 라인에 들어갈 수 없으면 새로운 라인 생성
        if not inserted:
            new_line = [0 for _ in range(max_day + 1)]
            for day in range(start, end + 1):
                new_line[day] = 1
            lines.append(new_line)

    # 코팅지 면적 구하기
    width, height = 0, 0
    answer = 0
    for day in range(1, max_day + 1): # 모든 날에 대하여 -> O(1)
        # 일정 개수 구하기
        schedule_cnt = sum(line[day] for line in lines)

        # 일정이 없다면 코팅지 면적 더하기, 높이 0
        if schedule_cnt == 0:
            answer += width * height
            width, height = 0, 0
            continue

        width += 1
        height = max(height, schedule_cnt)
        if day == max_day: # 마지막 날에는 무조건 계산
            answer += width * height

    return answer

print(solution())
