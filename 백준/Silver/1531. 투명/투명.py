"""테스트케이스 1 -> index err 검증
1 1
10 1 101 101
"""


def solution(points):
    arr = [[0 for _ in range(100)] for _ in range(100)]
    for sx, sy, ex, ey in points:
        height = ex - sx + 1
        width = ey - sy + 1
        for x in range(sx, sx + height):
            for y in range(sy, sy + width):
                arr[x - 1][y - 1] += 1

    return sum(val > M for row in arr for val in row)


if __name__ == "__main__":
    # 입력
    N, M = map(int, input().split())
    POINTS = [list(map(int, input().split())) for _ in range(N)]

    # 해결
    answer = solution(POINTS)

    # 출력
    print(answer)
