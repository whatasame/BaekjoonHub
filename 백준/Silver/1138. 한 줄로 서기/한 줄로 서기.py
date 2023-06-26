## 문제 분석
# 1 ~ N의 키를 갖는 사람 N명
# 자기보다 키 큰 사람이 앞에 몇 명 있는 지 안다.

def solution(arr):
    answer = [None for _ in range(N)]

    for n, val in enumerate(arr):
        cnt, idx = 0, 0

        while cnt < val:
            if answer[idx] is None:
                cnt += 1
            idx += 1

        while answer[idx] is not None:
            idx += 1

        answer[idx] = n + 1

    return answer


if __name__ == "__main__":
    # 입력
    N = int(input())
    arr = list(map(int, input().split()))

    # 해결
    answer = solution(arr)

    # 출력
    print(" ".join(map(str, answer)))
