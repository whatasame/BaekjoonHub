## 문제 분석
# N개의 트럭이 다리를 일렬로 건넌다
# 트럭의 무게는 서로 다를 수도 있다
# 다리는 w개의 트럭만 지나갈 수 있다.
# 다리의 길이는 w이고 최대 무게는 L이다
# 1초당 1씩 이동한다

from collections import deque


def solution(arr):
    timer, weight = 0, 0

    q = deque(arr)
    bridge = deque()

    while q or bridge:
        # 1초 경과
        timer += 1

        # 다리를 빠져나갈 트럭이 있는지 확인한다.
        if bridge:
            nw, nt = bridge[0]  # nw: 트럭 무게, nt: 남은 시간
            if nt == 0:
                bridge.popleft()
                weight -= nw

        # 다리에 트럭이 진입할 수 있으면 진입한다.
        if q:
            next = q[0]
            if weight + next <= L:
                next = q.popleft()
                bridge.append([next, W])
                weight += next

        # 다리의 모든 트럭이 1씩 이동한다
        for truck in bridge:
            truck[1] -= 1

    return timer


if __name__ == "__main__":
    # 입력
    N, W, L = map(int, input().split())
    arr = list(map(int, input().split()))

    # 해결
    answer = solution(arr)

    # 출력
    print(answer)
