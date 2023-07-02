## 문제 분석
# NxM 2차원 배열의 방 (0 -> 빈 칸, 1 -> 벽)
# 0123 -> NESW
# 전진: 바라보는 방향 앞쪽이 청소 안되어있을 경우
# 후진: 주변에 청소할 칸이 없는 경우
# 멈추는 조건: 후진할 수 없는 경우
# 회전 방향: 반시계 90도

"""테스트케이스1 -> 11
4 3
1 1 1
0 0 0
0 0 0
0 0 0
0 0 0
"""


def solution(arr):
    r, c, d = R, C, D
    cnt = 0

    while True:
        # 청소
        if arr[r][c] == 0:
            arr[r][c] = 2  # 2 ->  청소
            cnt += 1

        if check_arround(r, c):
            d = rotate(d)
            r, c = forward(r, c, d)
        else:
            r, c = backward(r, c, d)
            # 벽이라 후진 못함
            if not (0 <= r < N and 0 <= c < M) or arr[r][c] == 1:
                return cnt
            continue


def check_arround(r, c):
    for dr, dc in d_list:
        nr, nc = r + dr, c + dc

        # 주변 청소 X 찾기
        if 0 <= nr < N and 0 <= nc < M and arr[nr][nc] == 0:
            return True

    return False


def rotate(d):
    d -= 1
    d %= 4
    return d


def forward(r, c, d):
    dr, dc = d_list[d]
    nr, nc = r + dr, c + dc

    if 0 <= nr < N and 0 <= nc < M and arr[nr][nc] == 0:
        return nr, nc
    return r, c


def backward(r, c, d):
    dr, dc = d_list[d]
    return r - dr, c - dc


if __name__ == "__main__":
    # 입력
    N, M = map(int, input().split())
    R, C, D = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]

    # 해결
    d_list = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    answer = solution(arr)

    # 출력
    print(answer)
