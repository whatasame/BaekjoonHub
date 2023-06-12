# 문제 분석
# 1 <= x <= N인 한수 x의 개수
# 한자리 수도 한수이다. e.g. 1
# 등차수열은 감소할 수도 있다

import sys


def solution(N: int):
    cnt = 0
    for num in range(1, N + 1):  # 1 to N
        num_list = list(map(int, str(num)))

        cnt += is_han(num_list)
    return cnt


def is_han(num_list):
    gap = None
    for i in range(1, len(num_list)):
        now = num_list[i] - num_list[i - 1]
        if gap is not None and gap != now:
            return 0
        gap = now
    return 1


if __name__ == "__main__":
    # 입력
    input = sys.stdin.readline().rstrip
    N = int(input())

    # 해결
    answer = solution(N)

    # 출력
    print(answer)