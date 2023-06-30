## 문제 분석
# 두 사람을 비교할 때 몸무게와 키가 모두 커야 큰 덩치가 결정된다.

# N <= 50 -> brute force

# TODO) 더 좋은 시간 복잡도 풀이 방법은?

"""테스트 케이스 1 -> 1 1 1
3
7 7
7 7
7 7
"""

"""테스크 케이스 2 -> 2 2 1
3 
1 2
2 2
3 4
"""


def solution(arr):
    answer = [None] * N

    for i, e in enumerate(arr):
        rank = 1
        for comp in arr:
            if comp[0] > e[0] and comp[1] > e[1]:
                rank += 1
        answer[i] = rank

    return answer


if __name__ == "__main__":
    # 입력
    N = int(input())
    arr = [tuple(map(int, input().split())) for _ in range(N)]

    # 해결
    answer = solution(arr)

    # 출력
    print(*answer)
